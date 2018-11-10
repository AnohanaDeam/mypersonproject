
using System;
using System.Windows.Controls;

namespace 外卖导航
{
    class Backtrack
    {
        const int NO_PATH = -1;         //没有通路  
        const int MAX_WEIGHT = 4000;
        int[,] City_Graph;  //保存图信息  
        int[] x;                //x[i]保存第i步遍历的城市  
        int[] isIn;             //保存 城市i是否已经加入路径  
        int bestw;                 //最优路径总权值  
        int cw;                    //当前路径总权值  
        int[] bestx;
        int n;

        void Travel_Backtrack(int t)
        {        //递归法  
            int i, j;
            if (t > n)
            {
                for (i = 1; i <= n; i++)            //输出当前的路径  
                    Console.Write(x[i]);
                if (cw < bestw)
                {              //判断当前路径是否是更优解  
                    for (i = 1; i <= n; i++)
                    {
                        bestx[i] = x[i];
                    }
                    bestw = cw;
                    
                }
                Console.WriteLine("当前bestw：" + cw);//走完了，输出结果  
                return;
            }
            else
            {
                for (j = 1; j <= n; j++)
                {           //找到第t步能走的城市  
                    if (City_Graph[x[t - 1],j] != NO_PATH && 0==isIn[j])
                    { //能到而且没有加入到路径中  
                        isIn[j] = 1;
                        x[t] = j;
                        cw += City_Graph[x[t - 1],j];
                        Travel_Backtrack(t + 1);
                        isIn[j] = 0;
                        x[t] = 0;
                        cw -= City_Graph[x[t - 1],j];
                    }
                }
            }
        }
        public void Setpath(Position[] point, int p_num, int[,] a_map_1, int r, int c)
        {
            n = p_num;
            City_Graph = new int[n + 1, n + 1];
            x = new int[n + 1];
            isIn = new int[n + 1];
            bestx = new int[n + 1];
            MazeShortPath shortpath = new MazeShortPath();
            for (int i = 0; i <= n; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    City_Graph[i, j] = NO_PATH;
                }
            }
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (i != j)
                    {
                        Console.WriteLine(i + "-" + j);
                        City_Graph[i + 1, j + 1] = shortpath.Path_Load(r, c, point[i], point[j]);
                        Console.WriteLine("起-" + point[i].x + "," + point[i].y + "终-" + point[j].x + "," + point[j].y);
                    }
                }
            }
            for (int i = 1; i <= n; i++)
            {
                x[i] = 0;               //表示第i步还没有解  
                bestx[i] = 0;           //还没有最优解  
                isIn[i] = 0;            //表示第i个城市还没有加入到路径中  
            }
            x[1] = 1;                   //第一步 走城市1  
            isIn[1] = 1;                //第一个城市 加入路径  
            bestw = MAX_WEIGHT;
            cw = 0;
            Travel_Backtrack(2);        //从第二步开始选择城市  
            Console.WriteLine("最优值为" + bestw + "零阶矩阵:");
            for (int i = 0; i <= n; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    Console.Write(City_Graph[i, j] + " ");

                }
                Console.WriteLine("");
            }
            Console.WriteLine("最优解为:");
            for (int i = 1; i <= n; i++)
            {
                Console.Write(bestx[i] + ">>");
            }
            Console.WriteLine("");

            PositionForAll pfa = new PositionForAll();
            //Console.WriteLine("" + pfa.get_Start(1).x + "," + pfa.get_Start(1).y);
            //Console.WriteLine("" + pfa.get_End(1).x + "," + pfa.get_End(1).y);
            //pfa.show_Array();
        }
        public int[] get_bestx()
        {
            return bestx;
        }
    }
}
