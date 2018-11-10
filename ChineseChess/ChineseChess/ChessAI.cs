using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess
{
    class ChessAI:Chess
    {
        // 置换表项结构
        /*public struct HashItem
        {
            public int ucDepth, ucFlag;
            public int svl;
            public int wmv;
            public long dwLock0, dwLock1;
        };*/
        // 与搜索有关的全局变量
        public struct Search
        {
            public static int mvResult;                  // 电脑走的棋
            public static int[] nHistoryTable =new int[65536];      // 历史表
            /*public static int[,] mvKillers=new int[LIMIT_DEPTH,2]; // 杀手走法表
            public static HashItem[] HashTable=new HashItem[HASH_SIZE]; // 置换表*/
        }
        static PositionStruct pos;
        public void SetPositionStruct(PositionStruct pos)
        {
            ChessAI.pos = pos;
        }
        // 提取置换表项
        /*static int ProbeHash(int vlAlpha, int vlBeta, int nDepth, int mv)
        {
            bool bMate; // 杀棋标志：如果是杀棋，那么不需要满足深度条件
            HashItem hsh;

            hsh = Search.HashTable[pos.zobr.dwKey & (HASH_SIZE - 1)];
            if (hsh.dwLock0 != pos.zobr.dwLock0 || hsh.dwLock1 != pos.zobr.dwLock1)
            {
                mv = 0;
                return -MATE_VALUE;
            }
            mv = hsh.wmv;
            bMate = false;
            if (hsh.svl > WIN_VALUE)
            {
                hsh.svl -= pos.nDistance;
                bMate = true;
            }
            else if (hsh.svl < -WIN_VALUE)
            {
                hsh.svl += pos.nDistance;
                bMate = true;
            }
            if (hsh.ucDepth >= nDepth || bMate)
            {
                if (hsh.ucFlag == HASH_BETA)
                {
                    return (hsh.svl >= vlBeta ? hsh.svl : -MATE_VALUE);
                }
                else if (hsh.ucFlag == HASH_ALPHA)
                {
                    return (hsh.svl <= vlAlpha ? hsh.svl : -MATE_VALUE);
                }
                return hsh.svl;
            }
            return -MATE_VALUE;
        }
        // 保存置换表项
        public void RecordHash(int nFlag, int vl, int nDepth, int mv)
        {
            HashItem hsh;
            hsh = Search.HashTable[pos.zobr.dwKey & (HASH_SIZE - 1)];
            if (hsh.ucDepth > nDepth)
            {
                return;
            }
            hsh.ucFlag = nFlag;
            hsh.ucDepth = nDepth;
            if (vl > WIN_VALUE)
            {
                hsh.svl = vl + pos.nDistance;
            }
            else if (vl < -WIN_VALUE)
            {
                hsh.svl = vl - pos.nDistance;
            }
            else
            {
                hsh.svl = vl;
            }
            hsh.wmv = mv;
            hsh.dwLock0 = pos.zobr.dwLock0;
            hsh.dwLock1 = pos.zobr.dwLock1;
            Search.HashTable[pos.zobr.dwKey & (HASH_SIZE - 1)] = hsh;
        }
        // MVV/LVA每种子力的价值
        static int[] cucMvvLva = new int[24]{
            0, 0, 0, 0, 0, 0, 0, 0,
            5, 1, 1, 3, 4, 3, 2, 0,
            5, 1, 1, 3, 4, 3, 2, 0
        };
        // 求MVV/LVA值
        public int MvvLva(int mv)
        {
            return (cucMvvLva[pos.current_board[DST(mv)]] << 3) - cucMvvLva[pos.current_board[SRC(mv)]];
        }*/
        class CompareHistory : IComparer
        {
            int IComparer.Compare(Object x, Object y)
            {
                return ChessAI.Search.nHistoryTable[(int)y] - ChessAI.Search.nHistoryTable[(int)x];
            }
        }
        /*class CompareMvvLva : IComparer
        {
            ChessAI chessai = new ChessAI();
            int IComparer.Compare(Object x, Object y)
            {
                return chessai.MvvLva((int)y) - chessai.MvvLva((int)x); ;
            }
        }*/
        /*void Init(int mvHash_)
        { // 初始化，设定置换表走法和两个杀手走法
            mvHash = mvHash_;
            mvKiller1 = Search.mvKillers[pos.nDistance,0];
            mvKiller2 = Search.mvKillers[pos.nDistance,1];
            nPhase = PHASE_HASH;
        }
        int Next()
        {
            int mv;
            if(nPhase== PHASE_HASH)
            {
                nPhase = PHASE_KILLER_1;
                if (mvHash != 0)
                {
                    return mvHash;
                }
            }else if (nPhase == PHASE_KILLER_1)
            {
                nPhase = PHASE_KILLER_2;
                if (mvKiller1 != mvHash && mvKiller1 != 0 && pos.LegalMove(mvKiller1))
                {
                    return mvKiller1;
                }
            }else if (nPhase == PHASE_KILLER_2)
            {
                nPhase = PHASE_GEN_MOVES;
                if (mvKiller2 != mvHash && mvKiller2 != 0 && pos.LegalMove(mvKiller2))
                {
                    return mvKiller2;
                }

            }else if (nPhase == PHASE_GEN_MOVES)
            {
                nPhase = PHASE_REST;
                nGenMoves = pos.GenerateMoves(mvs);
                Array.Sort(mvs,0, nGenMoves,new CompareHistory());
                nIndex = 0;
            }else if (nPhase == PHASE_REST)
            {
                while (nIndex < nGenMoves)
                {
                    mv = mvs[nIndex];
                    nIndex++;
                    if (mv != mvHash && mv != mvKiller1 && mv != mvKiller2)
                    {
                        return mv;
                    }
                }
            }
            return 0;
        }
        // 对最佳走法的处理
        void SetBestMove(int mv, int nDepth)
        {
            int[] lpmvKillers=null;
            Search.nHistoryTable[mv] += nDepth * nDepth;
            for(int i=0;i<2;i++)
                lpmvKillers[i] = Search.mvKillers[pos.nDistance,i];
            if (lpmvKillers[0] != mv)
            {
                lpmvKillers[1] = lpmvKillers[0];
                lpmvKillers[0] = mv;
            }
        }
        // 静态(Quiescence)搜索过程
        static int SearchQuiesc(int vlAlpha, int vlBeta)
        {
            int i, nGenMoves;
            int vl, vlBest;
            int[] mvs =new int[MAX_GEN_MOVES];
            // 一个静态搜索分为以下几个阶段

            // 1. 检查重复局面
            vl = pos.RepStatus();
            if (vl != 0)
            {
                return pos.RepValue(vl);
            }

            // 2. 到达极限深度就返回局面评价
            if (pos.nDistance == LIMIT_DEPTH)
            {
                return pos.Evaluate();
            }

            // 3. 初始化最佳值
            vlBest = -MATE_VALUE; // 这样可以知道，是否一个走法都没走过(杀棋)

            if (pos.InCheck())
            {
                // 4. 如果被将军，则生成全部走法
                nGenMoves = pos.GenerateMoves(mvs);
                Array.Sort(mvs, 0, nGenMoves, new CompareHistory());
            }
            else
            {

                // 5. 如果不被将军，先做局面评价
                vl = pos.Evaluate();
                if (vl > vlBest)
                {
                    vlBest = vl;
                    if (vl >= vlBeta)
                    {
                        return vl;
                    }
                    if (vl > vlAlpha)
                    {
                        vlAlpha = vl;
                    }
                }

                // 6. 如果局面评价没有截断，再生成吃子走法
                nGenMoves = pos.GenerateMoves(mvs, GEN_CAPTURE);
                Array.Sort(mvs, 0, nGenMoves, new CompareMvvLva());
            }

            // 7. 逐一走这些走法，并进行递归
            for (i = 0; i < nGenMoves; i++)
            {
                if (pos.MakeMove(mvs[i]))
                {
                    vl = -SearchQuiesc(-vlBeta, -vlAlpha);
                    pos.UndoMakeMove();

                    // 8. 进行Alpha-Beta大小判断和截断
                    if (vl > vlBest)
                    {    // 找到最佳值(但不能确定是Alpha、PV还是Beta走法)
                        vlBest = vl;        // "vlBest"就是目前要返回的最佳值，可能超出Alpha-Beta边界
                        if (vl >= vlBeta)
                        { // 找到一个Beta走法
                            return vl;        // Beta截断
                        }
                        if (vl > vlAlpha)
                        { // 找到一个PV走法
                            vlAlpha = vl;     // 缩小Alpha-Beta边界
                        }
                    }
                }
            }
            // 9. 所有走法都搜索完了，返回最佳值
            return vlBest == -MATE_VALUE ? pos.nDistance - MATE_VALUE : vlBest;
        }*/
        // "SearchFull"的参数
        const bool NO_NULL = true;

        // 超出边界(Fail-Soft)的Alpha-Beta搜索过程
        public static int SearchFull(int vlAlpha, int vlBeta, int nDepth)
        {
            int i, nGenMoves, pcCaptured;
            int vl, vlBest, mvBest;
            int[] mvs=new int[MAX_GEN_MOVES];
            // 一个Alpha-Beta完全搜索分为以下几个阶段

                // 1. 到达水平线，则返回局面评价值
            if (nDepth <= 0)
            {
                    //return SearchQuiesc(vlAlpha, vlBeta);// 1. 到达水平线，则调用静态搜索(注意：由于空步裁剪，深度可能小于零)
                return pos.Evaluate();
            }
            // 2. 初始化最佳值和最佳走法
            vlBest = -MATE_VALUE; // 这样可以知道，是否一个走法都没走过(杀棋)
            mvBest = 0;           // 这样可以知道，是否搜索到了Beta走法或PV走法，以便保存到历史表

            // 3. 初始化走法排序结构
            nGenMoves = pos.GenerateMoves(mvs);
            Array.Sort(mvs, 0, nGenMoves, new CompareHistory());

            // 4. 逐一走这些走法，并进行递归
            for (i = 0; i < nGenMoves; i++)
            {
                pcCaptured = pos.MovePiece(mvs[i]);//试走一步棋
                if (pos.MakeMove(mvs[i]))
                {
                    vl = -SearchFull(-vlBeta, -vlAlpha, nDepth - 1);
                    pos.UndoMakeMove(mvs[i], pcCaptured);

                    // 5. 进行Alpha-Beta大小判断和截断
                    if (vl > vlBest)
                    {    // 找到最佳值(但不能确定是Alpha、PV还是Beta走法)
                        vlBest = vl;        // "vlBest"就是目前要返回的最佳值，可能超出Alpha-Beta边界
                        if (vl >= vlBeta)
                        { // 找到一个Beta走法
                            mvBest = mvs[i];  // Beta走法要保存到历史表
                            break;            // Beta截断
                        }
                        if (vl > vlAlpha)
                        { // 找到一个PV走法
                            mvBest = mvs[i];  // PV走法要保存到历史表
                            vlAlpha = vl;     // 缩小Alpha-Beta边界
                        }
                    }
                }
            }

            // 5. 所有走法都搜索完了，把最佳走法(不能是Alpha走法)保存到历史表，返回最佳值
            if (vlBest == -MATE_VALUE)
            {
                // 如果是杀棋，就根据杀棋步数给出评价
                return pos.nDistance - MATE_VALUE;
            }
            if (mvBest != 0)
            {
                // 如果不是Alpha走法，就将最佳走法保存到历史表
                Search.nHistoryTable[mvBest] += nDepth * nDepth;
                if (pos.nDistance == 0)
                {
                    // 搜索根节点时，总是有一个最佳走法(因为全窗口搜索不会超出边界)，将这个走法保存下来
                    Search.mvResult = mvBest;
                }
            }
            return vlBest;
        }

        // 迭代加深搜索过程
        public static void SearchMain()
        {
            int i, vl;
            // 初始化
            Array.Clear(Search.nHistoryTable, 0, Search.nHistoryTable.Length);
            //t = clock();       // 初始化定时器
            Stopwatch sw = new Stopwatch();
            long t = sw.ElapsedMilliseconds;
            pos.nDistance = 0; // 初始步数
            // 迭代加深过程
            sw.Start();
            for (i = 1; i <= LIMIT_DEPTH; i++)
            {
                vl = SearchFull(-MATE_VALUE, MATE_VALUE, i);
                // 搜索到杀棋，就终止搜索
                if (vl > WIN_VALUE || vl < -WIN_VALUE)
                {
                    break;
                }
                sw.Stop();
                // 超过一秒，就终止搜索
                if (sw.ElapsedMilliseconds - t > 1000)
                {
                    break;
                }
            }
        }
    }
}
