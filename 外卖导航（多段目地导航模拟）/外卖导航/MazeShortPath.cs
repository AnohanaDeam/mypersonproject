using System;

using System.Data;

using System.Configuration;

using System.Collections;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Threading;

namespace 外卖导航
{
    public struct QueueItem

    {

        public Position PreviousPos;//上一级坐标

        public Position CurrentPos;//当前坐标

    }

    public partial class MazeShortPath

    {

        Queue queue = new Queue();

        Stack stack = new Stack();

        Position EndPosition = new Position(); //终点
        Position StartPos = new Position(); //起点

        Position[] Walk_point = new Position[1024];
        int point_flag = 0;

        int[,] arrMaze;
        int row=0, column=0;
        int WalkLong = 0;

        public Position[] get_WalkPoint()
        {
            return Walk_point;
        }
        public int get_PointFlag()
        {
            return point_flag;
        }

        public int Path_Load(int r,int c, Position End, Position Start)
        { 
            int[,] a_map_1=new int[100,100];
            Loading_map a_map = new Loading_map("地图01.txt");
            a_map.Loading();
            a_map_1 = a_map.get_map();
            EndPosition = End;
            StartPos = Start;
            arrMaze = a_map_1;
            row = r;
            column = c;
            point_flag = 0;
            Page_Load();
            return WalkLong;
        }

        private void Page_Load()

        {
            

            //stackItem结构体是栈中的项

            QueueItem queueItem = new QueueItem();

            queueItem.CurrentPos = StartPos;

            queueItem.PreviousPos = StartPos;

            stack.Push(queueItem);

            #region 输出结果

            //PrintMaze(arrMaze);

            if (FindPath(queueItem, arrMaze, EndPosition))

            {

                PrintMazeShortPath(arrMaze);

            }

            else

            {

                Console.Write("没有路径\n");

                //PrintMazeShortPath();

            }

            //PrintMaze(arrMaze);

            #endregion 输出结果



            queue.Clear();

        }

        //迷宫求解递归函数

        private bool FindPath(QueueItem qItem, int[,] Maze, Position EndPos){
            QueueItem OriginItem = qItem;
            //沿当前项的四个方向个前进一步，如果是通路则加入队列，同时入栈
            for (int i = 1; i <= 4; i++)
            {
                switch (i)

                {

                    case 1:

                        qItem.CurrentPos.y = qItem.CurrentPos.y + 1;

                        break;

                    case 2:

                        qItem.CurrentPos.x = qItem.CurrentPos.x + 1;

                        break;

                    case 3:

                        qItem.CurrentPos.y = qItem.CurrentPos.y - 1;

                        break;

                    case 4:

                        qItem.CurrentPos.x = qItem.CurrentPos.x - 1;

                        break;

                    default:

                        break;

                }

                if (Maze[qItem.CurrentPos.x, qItem.CurrentPos.y] == 0)

                {

                    qItem.PreviousPos = OriginItem.CurrentPos;

                    stack.Push(qItem);

                    queue.Enqueue(qItem);

                    Maze[qItem.CurrentPos.x, qItem.CurrentPos.y] = 2;

                }

                if (qItem.CurrentPos.x == EndPos.x && qItem.CurrentPos.y == EndPos.y)

                {

                    return true;

                }

                qItem = OriginItem;

            }

            if (queue.Count > 0)

            {

                qItem = (QueueItem)queue.Dequeue();

            }

            else

            {

                return false;

            }

            bool bReturn = FindPath(qItem, Maze, EndPos);

            return bReturn;

        }

        //输出最短路径

        private void PrintMazeShortPath(int[,] Maze)

        {

            QueueItem CurItem = (QueueItem)stack.Pop();

            int OrderPath = 0;

            string OutputString = "\n";

            while (stack.Count > 0)

            {

                QueueItem PreItem = (QueueItem)stack.Pop();

                //从终点根据PreviousPos一直找到起点或者栈为空，此时所得到的路径就是迷宫的最短路径。

                if (CurItem.PreviousPos.x == PreItem.CurrentPos.x && CurItem.PreviousPos.y == PreItem.CurrentPos.y)

                {

                    Maze[CurItem.CurrentPos.x, CurItem.CurrentPos.y] = 3;

                    OutputString += "(" + CurItem.CurrentPos.x + "," + CurItem.CurrentPos.y + ")<<<";

                    Walk_point[point_flag] = CurItem.CurrentPos;
                    Console.WriteLine("point_flag为:" + point_flag + "--" + Walk_point[point_flag].x + ", " + Walk_point[point_flag].y);
                    point_flag++;

                    CurItem = PreItem;

                    OrderPath++;

                }

            }

            Maze[CurItem.CurrentPos.x, CurItem.CurrentPos.y] = 3;

            OutputString += "(" + CurItem.CurrentPos.x + "," + CurItem.CurrentPos.y + ") \n";
            Walk_point[point_flag] = CurItem.CurrentPos;
            Console.WriteLine("point_flag为:" + point_flag + "--" + Walk_point[point_flag].x + ", " + Walk_point[point_flag].y);

            OutputString += "[要想走出迷宫最少需要走：" + OrderPath.ToString() + "步]\n";

            WalkLong = OrderPath;

            Console.Write(OutputString);

        }
        //输出迷宫

        private void PrintMaze(int[,] Maze)//收尾工作

        {
            PositionForAll pfa = new PositionForAll();
            Console.WriteLine("传出时point_flag为:" + point_flag + "--" + Walk_point[point_flag].x + ", " + Walk_point[point_flag].y);
            pfa.Add_position_forAll(Walk_point,point_flag);

            Console.WriteLine("========================================================");

            for (int i = 0; i < row; i++)

            {

                for (int j = 0; j <column; j++)

                {
                    Console.Write("" + Maze[i, j]);
                }
                Console.WriteLine("");
            }

            Console.WriteLine("========================================================");



            try
            {
                string str = null;
                string filename = ""+StartPos.x+"p"+ StartPos.y+"_" +EndPosition.x +"p"+ EndPosition.y+".txt";
                //int[,] other_map = null;
                /*if (flag == 0)
                    filename = "地图01.txt";
                else
                    filename = "解出地图.txt";
                Loading_map loadfile = new Loading_map(filename);
                loadfile.Loading();
                other_map = loadfile.get_map();*/
                /*using (StreamWriter file = new StreamWriter(filename))
                {
                    for(int i = 0; i < row; i++)
                    {
                        for(int j = 0; j < column; j++)
                        {
                            //if(Maze[i, j]==3&&other_map[i, j]==0)
                                str += Maze[i, j];
                            //else
                            //    str += other_map[i, j];
                        }
                        file.WriteLine(str);
                        str = null;
                    }
                    file.Close();
                }*/
            }
            catch (Exception e)
            {
                MessageBox.Show("解出图输出失败:\n"+e);
            }

        }

    }

}