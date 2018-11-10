using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.IO;
using System.Reflection;
using System.Threading;

namespace 外卖导航
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    /// 

    public struct Position
    {
        public int x;
        public int y;
    }
    public struct PositionArray
    {
        public Position[] Position_Array;//start is Position_Array[0];end is Position_Array[n]
        public int n;
    }
    public partial class MainWindow : Window
    {
        const int MaxRow = 100;
        const int MaxColumn = 100;
        const int MaxPath = 10;

        private int path_num = 0,mr=0,mc=0;
        private TextBox box;
        private WrapPanel path_Con;
        private Grid grid;
        private int[,] a = new int[MaxRow, MaxColumn];
        private int[,] c = new int[MaxRow, MaxColumn];
        private int[] bestx = null;
        
        Position[] path = new Position[MaxPath];

        public void Output_a(int[,] as_map)
        {
            for(int i=0;i< mr; i++)
            {
                for (int j = 0; j < mc; j++)
                {
                    Console.Write("" + as_map[i, j]);
                }
                Console.WriteLine("");
            }
        }

        public MainWindow()
        {
            InitializeComponent();

            //初始化地图数据
            int map_row = 0, map_column = 0;
            Loading_map a_map = new Loading_map("地图01.txt");
            a_map.Loading();
            mr=map_row = a_map.getrow();
            mc=map_column = a_map.getcolumn();
            a = a_map.get_map();
            Console.WriteLine(map_row + "-" + map_column);

            //生成绘制地图表格
            grid = this.map_grid;
            path_Con = this.path_panel;
            box = this.start_path;
            for (int i = 0; i < map_row; i++){
                RowDefinition row = new RowDefinition();
                row.Height = new GridLength(1, GridUnitType.Star);
                grid.RowDefinitions.Add(row);
            }
            for(int j = 0; j < map_column; j++)
            {
                ColumnDefinition column = new ColumnDefinition();
                column.Width = new GridLength(1, GridUnitType.Star);
                grid.ColumnDefinitions.Add(column);
            }
            //填充表格
            for (int k = 0; k < map_row; k++)
            {
                for (int j = 0; j < map_column; j++)
                {
                    Button btn = new Button();
                    btn.Content = "";
                    btn.Name = "Button" + k +"_"+ j;
                    grid.RegisterName("Button" + k + "_" + j, btn);
                    btn.Style = (Style)FindResource("Borderless_style");
                    if (a[k, j] == 1) {
                        ImageBrush berriesBrush = new ImageBrush();
                        berriesBrush.ImageSource =
                        new BitmapImage(
                            new Uri(@"tree.jpg", UriKind.Relative)
                        );
                        btn.Background = berriesBrush;
                    }
                    else if(a[k, j] == 0|| a[k, j] == 7)
                    {
                        ImageBrush berriesBrush = new ImageBrush();
                        berriesBrush.ImageSource =
                        new BitmapImage(
                            new Uri(@"road.jpg", UriKind.Relative)
                        );
                        btn.Background = berriesBrush;
                    }
                    else if(a[k, j] == 9)
                    {
                        ImageBrush berriesBrush = new ImageBrush();
                        berriesBrush.ImageSource =
                        new BitmapImage(
                            new Uri(@"house.jpg", UriKind.Relative)
                        );
                        btn.Background = berriesBrush;
                    }
                    else if (a[k, j] == 8)
                    {
                        ImageBrush berriesBrush = new ImageBrush();
                        berriesBrush.ImageSource =
                        new BitmapImage(
                            new Uri(@"men.jpg", UriKind.Relative)
                        );
                        btn.Background = berriesBrush;
                    }
                    grid.Children.Add(btn);
                    Grid.SetRow(btn, k);
                    Grid.SetColumn(btn, j);
                    btn.Click += new RoutedEventHandler(Button_Click);
                }
            }
        }
        //响应地图事件
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button btn = sender as Button;
            for(int i = 0; i < mr; i++)
            {
                for (int j = 0; j < mc; j++)
                {
                    if (("Button"+i+ "_" + j) == btn.Name)
                    {
                        if (path_num == 0&& a[i, j] == 0)
                        {
                            box.Text = i + "-" + j;

                            path[path_num].x = i;
                            path[path_num].y = j;
                        }
                        else if(a[i,j]==0 && path_num<10)
                        {
                            TextBlock block = new TextBlock();
                            block.Style = (Style)FindResource("MyTextBlock");
                            block.Text = "路径:" + path_num;
                            TextBox in_box = new TextBox();
                            in_box.Style = (Style)FindResource("MyTextBox");
                            in_box.Text = i + "-" + j;
                            path_Con.Children.Add(block);
                            path_Con.Children.Add(in_box);
                            path_Con.RegisterName("newTextBlock"+ path_num, block);
                            path_Con.RegisterName("newTextBox"+ path_num, in_box);

                            path[path_num].x = i;
                            path[path_num].y = j;
                        }
                        else if (path_num > 10)
                        {
                            MessageBox.Show("路径已满>10");
                            return;
                        }
                        else
                        {
                            MessageBox.Show("这不是一个可去的路径");
                            return;
                        }
                        path_num++;
                    }
                }
            }      
        }
        private void Button_del(object sender, RoutedEventArgs e)
        {
            Del_Text();
        }
        private void Del_Text()
        {
            TextBlock tb = path_Con.FindName("newTextBlock" + (path_num - 1)) as TextBlock;
            TextBox tbx = path_Con.FindName("newTextBox" + (path_num - 1)) as TextBox;
            if (tb != null && tbx != null && path_num > 1)//判断是否找到，以免在未添加前就误点了  
            {
                path_Con.Children.Remove(tb);//移除对应TextBlock控件  
                path_Con.UnregisterName("newTextBlock" + (path_num - 1));
                path_Con.Children.Remove(tbx);//移除对应TextBox控件  
                path_Con.UnregisterName("newTextBox" + (path_num - 1));
                path_num--;
            }
            else if (path_num == 1)
            {
                box.Text = "点击地图输入路径点";
                path_num--;
            }
            else if (path_num == 0)
            {
                MessageBox.Show("路径已清空");
            }
            else
            {
                MessageBox.Show("找不到路径error:" + "\nnewTextBlock" + (path_num - 1) + "\nnewTextBox" + (path_num - 1) + "\n" + path_num);
            }
        }

        private void Button_rem_Click(object sender, RoutedEventArgs e)
        {
            reSetMap();
        }

        private void Button_Click_Play(object sender, RoutedEventArgs e)
        {
            MazeShortPath shortpath = new MazeShortPath();
            for (int i = 1; i < bestx.Length; i++)
            {
                if(i+1== bestx.Length)
                {
                    return;
                }
                else
                {
                    shortpath.Path_Load(mr, mc, path[bestx[i] - 1], path[bestx[i + 1] - 1]);
                    Position[] position_array = shortpath.get_WalkPoint();
                    int n = shortpath.get_PointFlag();
                    Console.WriteLine("到类时:n=" + n + "值为：");
                    for (int j = 0; j < n+1; j++)
                    {
                        Console.Write("(" + position_array[j].x + "," + position_array[j].y + ")");
                        Button c_btn = grid.FindName("Button" + position_array[j].x + "_" + position_array[j].y) as Button;
                        ImageBrush berriesBrush = new ImageBrush();
                        berriesBrush.ImageSource =
                        new BitmapImage(
                            new Uri(@"roadp.jpg", UriKind.Relative)
                        );
                        c_btn.Background = berriesBrush;

                    }
                }
            }
        }

        private void Button_Click_prev(object sender, RoutedEventArgs e)
        {
            MessageBoxResult dr;
            dr = MessageBox.Show("你点击了前一帧但目前还没有这个功能！", "严重警告", MessageBoxButton.YesNoCancel, MessageBoxImage.Stop);
            if (dr == MessageBoxResult.Yes)
            {
                MessageBox.Show("将关闭程序", "选择了“是”");
            }

            else if (dr == MessageBoxResult.No)
            {
                MessageBox.Show("将关闭程序", "选择了“否”");
            }
            else if (dr == MessageBoxResult.Cancel)
            {
                MessageBox.Show("将关闭程序", "选择了“取消”");
            }
            else
            {
                MessageBox.Show("你没有进行任何的操作！", "系统提4");
            }
            App.Current.Shutdown();
        }

        private void Button_Click_next(object sender, RoutedEventArgs e)
        {
            MessageBoxResult dr;
            dr = MessageBox.Show("你点击了下一帧但目前还没有这个功能！", "严重警告", MessageBoxButton.YesNoCancel, MessageBoxImage.Stop);
            if (dr == MessageBoxResult.Yes) {
                MessageBox.Show("将关闭程序", "选择了“是”");
            }
                
            else if (dr == MessageBoxResult.No)
            {
                MessageBox.Show("将关闭程序", "选择了“否”");
            } 
            else if (dr == MessageBoxResult.Cancel)
            {
                MessageBox.Show("将关闭程序", "选择了“取消”");
            }
            else
            {
                MessageBox.Show("你没有进行任何的操作！", "系统提4");
            }
            App.Current.Shutdown();
        }

        private void Button_Guide(object sender, RoutedEventArgs e)
        {
            reSetMap();
            MessageBox.Show("导航已开始稍等" + (path_num/1.0136).ToString("f5") + "秒");
            Backtrack backtrack = new Backtrack();
            backtrack.Setpath(path, path_num, a,mr,mc);
            bestx = backtrack.get_bestx();

            TextBlock head = this.head;
            String str = null;
            int j = 0;
            for(int i = 1; i < bestx.Length; i++)
            {
                if (bestx[i]-1 == 0)
                    str += "开始路径:(" + path[0].x + "," + path[0].y+")";
                else
                    str += "路径"+bestx[i] +":(" + path[bestx[i]-1].x + "," + path[bestx[i]-1].y+")";
                if (i != bestx.Length-1)
                    str += "=>> ";
            }
            MessageBox.Show(str, "导航完成",MessageBoxButton.OK,MessageBoxImage.Information);
            head.Text = "导航完成";
            int num = path_num;
            for (int i = 0; i < num; i++)
            {
                Del_Text();
            }
        }
        private void reSetMap()
        {
            Loading_map loadfile = new Loading_map("地图01.txt");
            loadfile.Loading();
            int[,] other_map = loadfile.get_map();
            for (int k = 0; k < mr; k++)
            {
                for (int j = 0; j < mc; j++)
                {
                    if (other_map[k, j] == 0)
                    {
                        Button c_btn = grid.FindName("Button" + k + "_" + j) as Button;
                        ImageBrush berriesBrush = new ImageBrush();
                        berriesBrush.ImageSource =
                        new BitmapImage(
                            new Uri(@"road.jpg", UriKind.Relative)
                        );
                        c_btn.Background = berriesBrush;
                    }

                }
            }
        }
    }
}