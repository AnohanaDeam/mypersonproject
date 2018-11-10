using System;

public class Loading_map
{
	public Loading_map(String map_name)
    {
        this.map_name = map_name;
        for (int i = 0; i < 100; i++)//初始化迷宫
        {
            for (int k = 0; k < 100; k++)
            {
                a[i, k] = 1;
            }
        }
    }
    public int getrow()
    {
        return map_row;
    }
    public int getcolumn()
    {
        return map_column;
    }
    public byte get_map()
    {
        return a;
    }
    private String map_name;
    private int map_row = 0, map_column = 0;
    private byte[,] a = new byte[100, 100];
    private void Loading()
    {
        try
        {
            using (StreamReader fin = new StreamReader(map_name))
            {
                char[] buffer = new char[100];

                // 从文件读取并显示行，直到文件的末尾 
                String line;
                while ((line = fin.ReadLine()) != null)
                {
                    buffer = line.ToArray();
                    map_column = buffer.Length;
                    //Console.WriteLine(buffer.Length+"-"+ (map_row+1));
                    //String str = fin.ReadLine();//.ToArray();
                    for (int i = 0; i < buffer.Length; i++)
                    {
                        a[map_row, i] = (byte)(buffer[i] - '0');
                        Console.Write(a[map_row, i]);
                    }
                    Console.WriteLine("");
                    map_row++;
                }
            }
        }
        catch (Exception e)
        {
            MessageBox.Show("文件读取错误:" + e);
        }
    }
}