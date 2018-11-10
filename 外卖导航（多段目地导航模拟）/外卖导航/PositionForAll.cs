using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace 外卖导航
{
    class PositionForAll
    {
        static PositionArray[] position_forAll = new PositionArray[100];
        static int f = 0;
        
        public Position get_End(int i)
        {
            return position_forAll[i].Position_Array[0];
        }
        public Position get_Start(int i)
        {
            return position_forAll[i].Position_Array[position_forAll[i].n];
        }
        public int get_Lenght()
        {
            return f;
        }

        public void Add_position_forAll(Position[] position_array,int n)
        {
            Console.WriteLine("到类时:f=" + f + "值为：" );
            for(int i = 0; i < n; i++)
            {
                Console.Write("("+position_array[i].x + "," + position_array[i].y+")");
            }
            Console.WriteLine("赋值后:point_flag=" + position_forAll[f].n + "值为" );
            f++;
        }
        public void show_Array()
        {
            Console.WriteLine("=*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*=");
            Console.WriteLine("展示路径点：");
            for (int j = 0; j < f; j++)
            {
                for (int i = 0; i < position_forAll[j].n; i++)
                {
                    Console.Write("(" + position_forAll[j].Position_Array[i].x + "," + position_forAll[j].Position_Array[i].y + ")");
                }
                Console.WriteLine("");
            }
        }
        public void del_Array()
        {
            position_forAll = null;
            f = 0;
        }
    }
}
