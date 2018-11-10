using System;
using System.Media;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;

namespace ChineseChess
{
    class Board:Chess
    {
        MainWindow.xqBoard xqwl;
        PositionStruct pos = new PositionStruct();
        ChessAI chessai = new ChessAI();
        DrawingGroup imageGroup;
        MainWindow mainwin;

        public Board(DrawingGroup drawpage,Image board,MainWindow mainwin)
        {
            imageGroup = drawpage;
            this.mainwin = mainwin;
            board.MouseDown += new MouseButtonEventHandler(grid_MouseDown);
        }

        private void grid_MouseDown(object sender, MouseButtonEventArgs e)
        {

            Point mouse_position = e.GetPosition((IInputElement)sender);
            int x = FILE_LEFT + ((int)mouse_position.X - BOARD_EDGE) / SQUARE_SIZE;
            int y = RANK_TOP + ((int)mouse_position.Y - BOARD_EDGE) / SQUARE_SIZE;
            if (x >= FILE_LEFT && x <= FILE_RIGHT && y >= RANK_TOP && y <= RANK_BOTTOM)
            {
                ClickSquare(COORD_XY(x, y));
            }
            /*Image dim = (Image)sender;
            grid.Children.Remove(dim);*/
            //MessageBox.Show("点击了"+ mouse_position.X+ ","+ mouse_position.Y);
        }

        public bool InitialBoard(MainWindow.xqBoard Xqwl)
        {
            xqwl = Xqwl;
            pos.Startup();
            chessai.SetPositionStruct(pos);
            xqwl.sqSelected = xqwl.mvLast = 0;
            DrawChess();
            return true;
        }
        public void DrawChess()
        {
            int x, y, xx, yy, sq, replace_chess;
            //绘制地图
            ImageDrawing drawborad = new ImageDrawing();
            drawborad.Rect=new Rect(0, 0, 520, 576);
            drawborad.ImageSource = xqwl.bmpBoard;
            imageGroup.Children.Add(drawborad);
            //绘制棋子
            for (x = FILE_LEFT; x <= FILE_RIGHT; x++)
            {
                for (y = RANK_TOP; y <= RANK_BOTTOM; y++)
                {
                    if (xqwl.bFlipped)
                    {
                        xx = BOARD_EDGE + (FILE_FLIP(x) - FILE_LEFT) * SQUARE_SIZE;
                        yy = BOARD_EDGE + (RANK_FLIP(y) - RANK_TOP) * SQUARE_SIZE;
                    }
                    else
                    {
                        xx = BOARD_EDGE + (x - FILE_LEFT) * SQUARE_SIZE;
                        yy = BOARD_EDGE + (y - RANK_TOP) * SQUARE_SIZE;
                    }
                    sq = COORD_XY(x, y);
                    replace_chess = pos.current_board[sq];

                    if (replace_chess != 0)
                    {
                        DrawImage(xx, yy, xqwl.bmpPieces[replace_chess]);
                    }
                    if (sq == xqwl.sqSelected || sq == SRC(xqwl.mvLast) || sq == DST(xqwl.mvLast))
                    {
                        DrawImage(xx, yy, xqwl.bmpSelected);
                    }
                }
            }
        }
        private bool DrawImage(int xx,int yy, BitmapImage bit)
        {
            ImageDrawing bigkiwi = new ImageDrawing();
            bigkiwi.Rect = new Rect(xx,yy,50,50);
            bigkiwi.ImageSource = bit;
            imageGroup.Children.Add(bigkiwi);
            
            return true;
        }

        private void DrawSquare(int sq, bool bSelected = false)
        {
            int sqFlipped, xx, yy, replace_chess;
            sqFlipped = xqwl.bFlipped ? SQUARE_FLIP(sq) : sq;
            xx = BOARD_EDGE + (FILE_X(sqFlipped) - FILE_LEFT) * SQUARE_SIZE;
            yy = BOARD_EDGE + (RANK_Y(sqFlipped) - RANK_TOP) * SQUARE_SIZE;
            replace_chess = pos.current_board[sq];

            //覆盖原来图片的方法

            if (replace_chess != 0)
            {
                DrawImage(xx, yy, xqwl.bmpPieces[replace_chess]);
            }
            if (bSelected)
            {
                DrawImage(xx, yy, xqwl.bmpSelected);
            }
        }
        private void ResponseMove()
        {
            // 电脑走一步棋
            mainwin.Cursor = Cursors.Wait;
            ChessAI.SearchMain();
            mainwin.Cursor = Cursors.Arrow;
            pos.MakeMove(ChessAI.Search.mvResult);
            // 清除上一步棋的选择标记
            DrawSquare(SRC(xqwl.mvLast));
            DrawSquare(DST(xqwl.mvLast));
            // 把电脑走的棋标记出来
            xqwl.mvLast = ChessAI.Search.mvResult;
            DrawSquare(SRC(xqwl.mvLast), DRAW_SELECTED);
            DrawSquare(DST(xqwl.mvLast), DRAW_SELECTED);
            if (pos.IsMate())
            {
                // 如果分出胜负，那么播放胜负的声音，并且弹出不带声音的提示框
                //PlayResWav(IDR_LOSS);
                MessageBox.Show("请再接再厉！");
            }
            else
            {
                // 如果没有分出胜负，那么播放将军、吃子或一般走子的声音
                //PlayResWav(pos.Checked() ? IDR_CHECK2 : pcCaptured != 0 ? IDR_CAPTURE2 : IDR_MOVE2);
            }
        }
        private void ClickSquare(int sq)
        {
            int pc, mv;
            sq = xqwl.bFlipped ? SQUARE_FLIP(sq) : sq;
            pc = pos.current_board[sq];

            if ((pc & SIDE_TAG(pos.current_player)) != 0)
            {
                // 如果点击自己的子，那么直接选中该子
                if (xqwl.sqSelected != 0)
                {
                    DrawSquare(xqwl.sqSelected);
                }
                xqwl.sqSelected = sq;
                DrawSquare(sq, DRAW_SELECTED);
                if (xqwl.mvLast != 0)
                {
                    DrawSquare(SRC(xqwl.mvLast));
                    DrawSquare(DST(xqwl.mvLast));
                }
                //PlayResWav(IDR_CLICK); // 播放点击的声音
            }

            if ((pc & SIDE_TAG(pos.current_player)) != 0)
            {
                // 如果点击自己的子，那么直接选中该子
                if (xqwl.sqSelected != 0)
                {
                    DrawSquare(xqwl.sqSelected);
                }
                xqwl.sqSelected = sq;
                DrawSquare(sq, true);//画选中图片
                if (xqwl.mvLast != 0)
                {
                    DrawSquare(SRC(xqwl.mvLast));
                    DrawSquare(DST(xqwl.mvLast));
                }
                 //... 播放点击的声音

            }
            else if (xqwl.sqSelected != 0)
            {
                // 如果点击的不是自己的子，但有子选中了(一定是自己的子)，那么走这个子
                mv = MOVE(xqwl.sqSelected, sq);
                if (pos.LegalMove(mv))
                {
                    if (pos.MakeMove(mv))
                    {
                        xqwl.mvLast = mv;
                        DrawSquare(xqwl.sqSelected, true);
                        DrawSquare(sq, true);
                        xqwl.sqSelected = 0;    
                        if (pos.IsMate())
                        {
                            // 如果分出胜负，那么播放胜负的声音，并且弹出不带声音的提示框
                            MessageBox.Show("祝贺你取得胜利！");
                        }
                        else
                        {
                            // 播放被将军的声音PlayResWav(IDR_ILLEGAL);
                            ResponseMove(); // 轮到电脑走棋
                        }
                    }
                    else
                    {
                        // 播放被将军的声音
                    }
                }
                // 如果根本就不符合走法(例如马不走日字)，那么程序不予理会
            }
            imageGroup.Children.Clear();
            DrawChess();
        }
        // 初始化棋局
        public void Startup()
        {
            pos.Startup();
            xqwl.sqSelected = xqwl.mvLast = 0;
        }
    }
}