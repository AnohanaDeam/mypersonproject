using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace ChineseChess
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public struct xqBoard
        {
            public bool bFlipped, bGameOver;
            public BitmapImage[] bmpPieces;
            public BitmapImage bmpSelected;
            public BitmapImage bmpBoard;
            public int sqSelected, mvLast;
        }
        public MainWindow()
        {
            InitializeComponent();
            Board qipan = new Board(drawpage,board,this);
            qipan.Startup();
            qipan.InitialBoard(InitialxqBoard());
        }
        private xqBoard InitialxqBoard()
        {
            Chess chess = new Chess();
            xqBoard xqwl = new xqBoard();
            xqwl.bmpPieces = new BitmapImage[24];
            //加载图片资源
            xqwl.bmpBoard = new BitmapImage(new Uri(@"images/BOARD.BMP", UriKind.Relative));
            xqwl.bmpSelected = new BitmapImage(new Uri(@"images/SELECTED.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(0) + 0] = new BitmapImage(new Uri(@"images/RK.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(1) + 0] = new BitmapImage(new Uri(@"images/BK.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(0) + 1] = new BitmapImage(new Uri(@"images/RA.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(1) + 1] = new BitmapImage(new Uri(@"images/BA.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(0) + 2] = new BitmapImage(new Uri(@"images/RB.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(1) + 2] = new BitmapImage(new Uri(@"images/BB.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(0) + 3] = new BitmapImage(new Uri(@"images/RN.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(1) + 3] = new BitmapImage(new Uri(@"images/BN.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(0) + 4] = new BitmapImage(new Uri(@"images/RR.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(1) + 4] = new BitmapImage(new Uri(@"images/BR.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(0) + 5] = new BitmapImage(new Uri(@"images/RC.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(1) + 5] = new BitmapImage(new Uri(@"images/BC.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(0) + 6] = new BitmapImage(new Uri(@"images/RP.png", UriKind.Relative));
            xqwl.bmpPieces[chess.SIDE_TAG(1) + 6] = new BitmapImage(new Uri(@"images/BP.png", UriKind.Relative));
            xqwl.bFlipped = true;
            return xqwl;
        }
        
    }
}