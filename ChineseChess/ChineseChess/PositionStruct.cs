using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess
{
    class PositionStruct : Chess//局面结构
    {
        public int current_player;                   // 轮到谁走，0=红方，1=黑方
        public int[] current_board = new int[256];          // 棋盘上的棋子
        public int vlWhite, vlBlack;           // 红、黑双方的子力价值
        public int nDistance;        // 距离根节点的步数，历史走法数: nMoveNum

        /*public void ClearBoard()
        {         // 清空棋盘
            current_player = vlWhite = vlBlack = nDistance = 0;
            current_board = null;
            zobr.InitZero();
        }
        public void SetIrrev()
        {           // 清空(初始化)历史走法信息
            mvsList[0].Set(0, 0, Checked(), zobr.dwKey);
            nMoveNum = 1;
        }*/

        public void Startup()// 初始化棋盘
        {
            int sq, pc;
            current_player = vlWhite = vlBlack = nDistance = 0;
            //zobr.InitZero();
            for (sq = 0; sq < 256; sq++)
            {
                pc = initial_board[sq];
                if (pc != 0)
                {
                    AddPiece(sq, pc);
                }
            }
        }
        public void ChangeSide()// 交换走子方
        {
            current_player = 1 - current_player;
            //Zobrist表相关zobr.Xor(MainWindow.Zobrist.Player);
        }
        public void AddPiece(int sq, int pc)// 在棋盘上放一枚棋子
        {
            current_board[sq] = pc;

            // 红方加分，黑方(注意"cucvlPiecePos"取值要颠倒)减分
            if (pc < 16)
            {
                vlWhite += cucvlPiecePos[pc - 8, sq];
                //zobr.Xor(ZobristStruct.Zobrist.Table[pc - 8, sq]);
            }
            else
            {
                vlBlack += cucvlPiecePos[pc - 16, SQUARE_FLIP(sq)];
                //zobr.Xor(ZobristStruct.Zobrist.Table[pc - 9, sq]);
            }
        }
        public void DelPiece(int sq, int pc)// 从棋盘上拿走一枚棋子
        {
            current_board[sq] = 0;

            // 红方减分，黑方(注意"cucvlPiecePos"取值要颠倒)加分
            if (pc < 16)
            {
                vlWhite -= ChessAI.cucvlPiecePos[pc - 8, sq];
                //zobr.Xor(ZobristStruct.Zobrist.Table[pc - 8, sq]);
            }
            else
            {
                vlBlack -= ChessAI.cucvlPiecePos[pc - 16, SQUARE_FLIP(sq)];
                //zobr.Xor(ZobristStruct.Zobrist.Table[pc - 9, sq]);
            }
        }

        public int Evaluate()// 局面评价函数
        {
            return (current_player == 0 ? vlWhite - vlBlack : vlBlack - vlWhite) + ADVANCED_VALUE;
        }

        /*public bool InCheck()
        {      // 是否被将军
            return mvsList[nMoveNum - 1].ucbCheck != 0;
        }
        public bool Captured()
        {     // 上一步是否吃子
            return mvsList[nMoveNum - 1].ucpcCaptured != 0;
        }*/
        public int MovePiece(int mv)// 搬一步棋的棋子
        {
            int sqSrc, sqDst, pc, pc_Captured;
            sqSrc = SRC(mv);
            sqDst = DST(mv);
            pc_Captured = current_board[sqDst];
            if (pc_Captured != 0)
            {
                Console.WriteLine("位置A");
                DelPiece(sqDst, pc_Captured);
            }
            pc = current_board[sqSrc];
            Console.WriteLine("位置B");
            DelPiece(sqSrc, pc);
            AddPiece(sqDst, pc);
            return pc_Captured;
        }
        public void UndoMovePiece(int mv, int pcCaptured)// 撤消搬一步棋的棋子
        {
            int sqSrc, sqDst, pc;
            sqSrc = SRC(mv);
            sqDst = DST(mv);
            pc = current_board[sqDst];
            Console.WriteLine("位置C");
            DelPiece(sqDst, pc);
            AddPiece(sqSrc, pc);
            if (pcCaptured != 0)
            {
                AddPiece(sqDst, pcCaptured);
            }
        }
        public bool MakeMove(int mv)// 走一步棋
        {
            int pcCaptured;
            pcCaptured = MovePiece(mv);
            if (Checked())
            {
                UndoMovePiece(mv, pcCaptured);
                return false;
            }
            ChangeSide();
            nDistance++;
            return true;
        }
        public void UndoMakeMove(int mv, int pcCaptured)
        {
            nDistance--;
            //nMoveNum--;
            ChangeSide();
            UndoMovePiece(mv,pcCaptured);
        }
        /*public void NullMove()
        {
            long dwKey;
            dwKey = zobr.dwKey;
            ChangeSide();
            mvsList[nMoveNum].Set(0, 0, false, dwKey);
            nMoveNum++;
            nDistance++;
        }
        public void UndoNullMove()
        {                   // 撤消走一步空步
            nDistance--;
            nMoveNum--;
            ChangeSide();
        }*/
        // 生成所有走法，如果"bCapture"为"TRUE"则只生成吃子走法
        public int GenerateMoves(int[] mvs, bool bCapture = false)// 生成所有走法
        {
            int i, j, nGenMoves, nDelta, sqSrc, sqDst;
            int pcSelfSide, pcOppSide, pcSrc, pcDst;
            // 生成所有走法，需要经过以下几个步骤：
            nGenMoves = 0;
            pcSelfSide = SIDE_TAG(current_player);
            pcOppSide = OPP_SIDE_TAG(current_player);
            for (sqSrc = 0; sqSrc < 256; sqSrc++)
            {
                // 1. 找到一个本方棋子，再做以下判断：
                pcSrc = current_board[sqSrc];
                if ((pcSrc & pcSelfSide) == 0)
                {
                    continue;
                }
                // 2. 根据棋子确定走法
                switch (pcSrc - pcSelfSide)
                {
                    case PIECE_KING:
                        for (i = 0; i < 4; i++)
                        {
                            sqDst = sqSrc + King_Way[i];
                            if (!IN_FORT(sqDst))
                            {
                                continue;
                            }
                            pcDst = current_board[sqDst];
                            if (bCapture ? (pcDst & pcOppSide) != 0 : (pcDst & pcSelfSide) == 0)
                            {
                                mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                nGenMoves++;
                            }
                        }
                        break;
                    case PIECE_ADVISOR:
                        for (i = 0; i < 4; i++)
                        {
                            sqDst = sqSrc + Advisor_Way[i];
                            if (!IN_FORT(sqDst))
                            {
                                continue;
                            }
                            pcDst = current_board[sqDst];
                            if (bCapture ? (pcDst & pcOppSide) != 0 : (pcDst & pcSelfSide) == 0)
                            {
                                mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                nGenMoves++;
                            }
                        }
                        break;
                    case PIECE_BISHOP:
                        for (i = 0; i < 4; i++)
                        {
                            sqDst = sqSrc + Advisor_Way[i];
                            if (!(IN_BOARD(sqDst) && HOME_HALF(sqDst, current_player) && current_board[sqDst] == 0))
                            {
                                continue;
                            }
                            sqDst += Advisor_Way[i];
                            pcDst = current_board[sqDst];
                            if (bCapture ? (pcDst & pcOppSide) != 0 : (pcDst & pcSelfSide) == 0)
                            {
                                mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                nGenMoves++;
                            }
                        }
                        break;
                    case PIECE_KNIGHT:
                        for (i = 0; i < 4; i++)
                        {
                            sqDst = sqSrc + King_Way[i];
                            if (current_board[sqDst] != 0)
                            {
                                continue;
                            }
                            for (j = 0; j < 2; j++)
                            {
                                sqDst = sqSrc + Knight_Way[i, j];
                                if (!IN_BOARD(sqDst))
                                {
                                    continue;
                                }
                                pcDst = current_board[sqDst];
                                if (bCapture ? (pcDst & pcOppSide) != 0 : (pcDst & pcSelfSide) == 0)
                                {
                                    mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                    nGenMoves++;
                                }
                            }
                        }
                        break;
                    case PIECE_ROOK:
                        for (i = 0; i < 4; i++)
                        {
                            nDelta = King_Way[i];
                            sqDst = sqSrc + nDelta;
                            while (IN_BOARD(sqDst))
                            {
                                pcDst = current_board[sqDst];
                                if (pcDst == 0)
                                {
                                    mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                    nGenMoves++;
                                }
                                else
                                {
                                    if ((pcDst & pcOppSide) != 0)
                                    {
                                        mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                        nGenMoves++;
                                    }
                                    break;
                                }
                                sqDst += nDelta;
                            }
                        }
                        break;
                    case PIECE_CANNON:
                        for (i = 0; i < 4; i++)
                        {
                            nDelta = King_Way[i];
                            sqDst = sqSrc + nDelta;
                            while (IN_BOARD(sqDst))
                            {
                                pcDst = current_board[sqDst];
                                if (pcDst == 0)
                                {
                                    mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                    nGenMoves++;
                                }
                                else
                                {
                                    break;
                                }
                                sqDst += nDelta;
                            }
                            sqDst += nDelta;
                            while (IN_BOARD(sqDst))
                            {
                                pcDst = current_board[sqDst];
                                if (pcDst != 0)
                                {
                                    if ((pcDst & pcOppSide) != 0)
                                    {
                                        mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                        nGenMoves++;
                                    }
                                    break;
                                }
                                sqDst += nDelta;
                            }
                        }
                        break;
                    case PIECE_PAWN:
                        sqDst = SQUARE_FORWARD(sqSrc, current_player);
                        if (IN_BOARD(sqDst))
                        {
                            pcDst = current_board[sqDst];
                            if (bCapture ? (pcDst & pcOppSide) != 0 : (pcDst & pcSelfSide) == 0)
                            {
                                mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                nGenMoves++;
                            }
                        }
                        if (AWAY_HALF(sqSrc, current_player))
                        {
                            for (nDelta = -1; nDelta <= 1; nDelta += 2)
                            {
                                sqDst = sqSrc + nDelta;
                                if (IN_BOARD(sqDst))
                                {
                                    pcDst = current_board[sqDst];
                                    if (bCapture ? (pcDst & pcOppSide) != 0 : (pcDst & pcSelfSide) == 0)
                                    {
                                        mvs[nGenMoves] = MOVE(sqSrc, sqDst);
                                        nGenMoves++;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
            return nGenMoves;
        }
        public bool LegalMove(int mv)// 判断走法是否合理
        {
            int sqSrc, sqDst, sqPin;
            int pcSelfSide, pcSrc, pcDst, nDelta;
            // 判断走法是否合法，需要经过以下的判断过程：
            // 1. 判断起始格是否有自己的棋子
            sqSrc = SRC(mv);
            pcSrc = current_board[sqSrc];
            pcSelfSide = SIDE_TAG(current_player);
            if ((pcSrc & pcSelfSide) == 0)
            {
                return false;
            }
            // 2. 判断目标格是否有自己的棋子
            sqDst = DST(mv);
            pcDst = current_board[sqDst];
            if ((pcDst & pcSelfSide) != 0)
            {
                return false;
            }
            // 3. 根据棋子的类型检查走法是否合理
            switch (pcSrc - pcSelfSide)
            {
                case PIECE_KING:
                    return IN_FORT(sqDst) && KING_SPAN(sqSrc, sqDst);
                case PIECE_ADVISOR:
                    return IN_FORT(sqDst) && ADVISOR_SPAN(sqSrc, sqDst);
                case PIECE_BISHOP:
                    return SAME_HALF(sqSrc, sqDst) && BISHOP_SPAN(sqSrc, sqDst) &&
                        current_board[BISHOP_PIN(sqSrc, sqDst)] == 0;
                case PIECE_KNIGHT:
                    sqPin = KNIGHT_PIN(sqSrc, sqDst);
                    return sqPin != sqSrc && current_board[sqPin] == 0;
                case PIECE_ROOK:
                case PIECE_CANNON:
                    if (SAME_RANK(sqSrc, sqDst))
                    {
                        nDelta = (sqDst < sqSrc ? -1 : 1);
                    }
                    else if (SAME_FILE(sqSrc, sqDst))
                    {
                        nDelta = (sqDst < sqSrc ? -16 : 16);
                    }
                    else
                    {
                        return false;
                    }
                    sqPin = sqSrc + nDelta;
                    while (sqPin != sqDst && current_board[sqPin] == 0)
                    {
                        sqPin += nDelta;
                    }
                    if (sqPin == sqDst)
                    {
                        return pcDst == 0 || pcSrc - pcSelfSide == PIECE_ROOK;
                    }
                    else if (pcDst != 0 && pcSrc - pcSelfSide == PIECE_CANNON)
                    {
                        sqPin += nDelta;
                        while (sqPin != sqDst && current_board[sqPin] == 0)
                        {
                            sqPin += nDelta;
                        }
                        return sqPin == sqDst;
                    }
                    else
                    {
                        return false;
                    }
                case PIECE_PAWN:
                    if (AWAY_HALF(sqDst, current_player) && (sqDst == sqSrc - 1 || sqDst == sqSrc + 1))
                    {
                        return true;
                    }
                    return sqDst == SQUARE_FORWARD(sqSrc, current_player);
                default:
                    return false;
            }
        }
        bool Checked()
        {
            int i, j, sqSrc, sqDst;
            int pcSelfSide, pcOppSide, pcDst, nDelta;
            pcSelfSide = SIDE_TAG(current_player);
            pcOppSide = OPP_SIDE_TAG(current_player);
            // 找到棋盘上的帅(将)，再做以下判断：

            for (sqSrc = 0; sqSrc < 256; sqSrc++)
            {
                if (current_board[sqSrc] != pcSelfSide + PIECE_KING)
                {
                    continue;
                }

                // 1. 判断是否被对方的兵(卒)将军
                if (current_board[SQUARE_FORWARD(sqSrc, current_player)] == pcOppSide + PIECE_PAWN)
                {
                    return true;
                }
                for (nDelta = -1; nDelta <= 1; nDelta += 2)
                {
                    if (current_board[sqSrc + nDelta] == pcOppSide + PIECE_PAWN)
                    {
                        return true;
                    }
                }

                // 2. 判断是否被对方的马将军(以仕(士)的步长当作马腿)
                for (i = 0; i < 4; i++)
                {
                    if (current_board[sqSrc + Advisor_Way[i]] != 0)
                    {
                        continue;
                    }
                    for (j = 0; j < 2; j++)
                    {
                        pcDst = current_board[sqSrc + KnightCheck_Way[i, j]];
                        if (pcDst == pcOppSide + PIECE_KNIGHT)
                        {
                            return true;
                        }
                    }
                }
                // 3. 判断是否被对方的车或炮将军(包括将帅对脸)
                for (i = 0; i < 4; i++)
                {
                    nDelta = King_Way[i];
                    sqDst = sqSrc + nDelta;
                    while (IN_BOARD(sqDst))
                    {
                        pcDst = current_board[sqDst];
                        if (pcDst != 0)
                        {
                            if (pcDst == pcOppSide + PIECE_ROOK || pcDst == pcOppSide + PIECE_KING)
                            {
                                return true;
                            }
                            break;
                        }
                        sqDst += nDelta;
                    }
                    sqDst += nDelta;
                    while (IN_BOARD(sqDst))
                    {
                        pcDst = current_board[sqDst];
                        if (pcDst != 0)
                        {
                            if (pcDst == pcOppSide + PIECE_CANNON)
                            {
                                return true;
                            }
                            break;
                        }
                        sqDst += nDelta;
                    }
                }
                return false;
            }
            return false;
        }                   // 判断是否被将军
        public bool IsMate()// 判断是否被杀
        {
            int i, nGenMoveNum, pc_Captured;
            int[] mvs = new int[128];
            nGenMoveNum = GenerateMoves(mvs);
            for (i = 0; i < nGenMoveNum; i++)
            {
                pc_Captured = MovePiece(mvs[i]);
                if (!Checked())
                {
                    UndoMovePiece(mvs[i], pc_Captured);
                    return false;
                }
                else
                {
                    UndoMovePiece(mvs[i], pc_Captured);
                }
            }
            return true;
        }
        /*public int DrawValue()
        {
            return (nDistance & 1) == 0 ? -DRAW_VALUE : DRAW_VALUE;
        }
        public int RepStatus(int nRecur=1)
        {
            bool bSelfSide, bPerpCheck, bOppPerpCheck;
            MoveStruct[] lpmvs;
            int i = nMoveNum - 1;

            bSelfSide = false;
            bPerpCheck = bOppPerpCheck = true;
            lpmvs = mvsList;
            while (lpmvs[i].wmv != 0 && lpmvs[i].ucpcCaptured == 0)
            {
                if (bSelfSide)
                {
                    bPerpCheck = bPerpCheck && lpmvs[i].ucbCheck != 0;
                    if (lpmvs[i].dwKey == zobr.dwKey)
                    {
                        nRecur--;
                        if (nRecur == 0)
                        {
                            return 1 + (bPerpCheck ? 2 : 0) + (bOppPerpCheck ? 4 : 0);
                        }
                    }
                }
                else
                {
                    bOppPerpCheck = bOppPerpCheck && lpmvs[i].ucbCheck != 0;
                }
                bSelfSide = !bSelfSide;
                i--;
            }
            return 0;
        }
        public int RepValue(int nRepStatus)
        {
            int vlReturn;
            vlReturn = ((nRepStatus & 2) == 0 ? 0 : nDistance - MATE_VALUE) +
                ((nRepStatus & 4) == 0 ? 0 : MATE_VALUE - nDistance);
            return vlReturn == 0 ? DrawValue() : vlReturn;
        }
        public bool NullOkay()
        {                 // 判断是否允许空步裁剪
            return (current_player == 0 ? vlWhite : vlBlack) > NULL_MARGIN;
        }*/
    }
}