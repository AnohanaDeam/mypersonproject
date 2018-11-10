using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChineseChess
{
    class ZobristStruct// Zobrist结构
    {
        public long dwKey=0, dwLock0=0, dwLock1=0;
        public void InitZero() // 用零填充Zobrist
        {
            dwKey = dwLock0 = dwLock1 = 0;
        }
        public void InitRC4(RC4Struct rc4)
        {        // 用密码流填充Zobrist
            dwKey = rc4.NextLong();
            dwLock0 = rc4.NextLong();
            dwLock1 = rc4.NextLong();
        }
        public void Xor(ZobristStruct zobr)// 执行XOR操作
        { 
            dwKey ^= zobr.dwKey;
            dwLock0 ^= zobr.dwLock0;
            dwLock1 ^= zobr.dwLock1;
        }
        public void Xor(ZobristStruct zobr1, ZobristStruct zobr2)
        {
            dwKey ^= zobr1.dwKey ^ zobr2.dwKey;
            dwLock0 ^= zobr1.dwLock0 ^ zobr2.dwLock0;
            dwLock1 ^= zobr1.dwLock1 ^ zobr2.dwLock1;
        }
    }
}