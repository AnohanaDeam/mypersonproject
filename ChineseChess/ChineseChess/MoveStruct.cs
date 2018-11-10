using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess
{
    class MoveStruct// 历史走法信息(占4字节)
    {
        public int wmv;
        public int ucpcCaptured, ucbCheck;
        public long dwKey;

        public void Set(int mv, int pcCaptured, bool bCheck, long dwKey_)
        {
            wmv = mv;
            ucpcCaptured = pcCaptured;
            ucbCheck = bCheck ? 1 : 0;
            dwKey = dwKey_;
        }
    }
}
