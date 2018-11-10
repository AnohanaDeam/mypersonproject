#include"stdio.h"
#include"stdlib.h"
#include"windows.h"
#include"string.h"
struct book_type//图书信息结构体
{
	char num[20];
	char name[20];
	char writer[20];
	int book_num;
	char publish[20];
	char day[20];
	int money;
}book[20];
struct user_type//读者信息结构体
{
	char num[20];
	char password[20];
}use[20];
struct user_inf//读者借书信息
{
	char num[20];
	char name[20];
	int book_num;
}inf[20]; 
typedef struct 
{
	char user_num[20];
	char book_num[20];
}borrow_list;

void welcome();//欢迎界面
void menu();//主菜单
void xuanzhe();//退出选择
void adminlogin();//管理员登陆界面
void adminmenu();//管理员菜单
void input_book();//载入图书
void display_book();//查找图书
void delbook();//删除图书信息
void amend();//图书修改
void insert();//图书添加
void usermenu(int );//读者菜单
void borrow(int);//借书界面
void search_name(int);//搜索{
void search_num(int);
void search_writer(int);
void search_menu(int);//}
void give_back(int);
void user_select();
void userlog();//读者登陆
void userregister();//读者注册
void personal(int);
void readin_inf(struct book_type book[],int ,int);//写入借书信息
void inf_amend(int);
void password_amend(int);

void main()
{
	welcome();
	menu();

}
void readin_inf(struct book_type book[20],int i,int x)
{
	borrow_list list;
	FILE *fp;
	int j,n;
	if((fp=fopen("user_inf.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件");
		usermenu(x);
	}
	for(j=0;(!feof(fp));j++)
		fread(&inf[i],sizeof(struct user_inf),1,fp);
	inf[x].book_num=inf[x].book_num+1;
	n=j;
	if((fp=fopen("book_list.txt","w"))==NULL)
	{
		printf("\t\t无法打开文件");
		menu();
	}
	for(j=0;j<n;j++)
		fwrite(&inf[i],sizeof(struct user_inf),1,fp);
	fclose(fp);
	if((fp=fopen("borrow_list.txt","a"))==NULL)
	{
		printf("\t\t无法打开文件");
		menu();
	}
	stpcpy(list.book_num,book[i].num);
	fwrite(&list,sizeof(borrow_list),1,fp);
	fclose(fp);
}
void welcome()//欢迎界面
{
	int i;
	printf("\t\t");
	for(i=1;i<39;i++)
	{
		printf("=");
		Sleep(5);
	}
	printf("\n\t\t||\t                            ||");
	printf("\n\t\t||\t                            ||");
	printf("\n\t\t||\t欢迎使用图书管理系统        ||");
	printf("\n\t\t||\t                            ||");
	printf("\n\t\t||\t            ——made by 赵  ||\n\t\t");
	for(i=1;i<39;i++)
	{
		printf("=");
		Sleep(5);
	}
	printf("\n\t\t\t按回车键进入系统");
	getchar();
	system("cls");
}
void menu()//主菜单
{
	int a;
	system("cls");
	printf("\t\t======================================\n");
	printf("\t\t||\t[1].我是读者                ||\n");
	printf("\t\t||\t[2].读者注册                ||\n");
	printf("\t\t||\t[3].图书查询                ||\n");
	printf("\t\t||\t[4].我是管理员              ||\n");
	printf("\t\t||\t[5].退出系统                ||\n");
	printf("\t\t======================================\n");
	printf("\t\t请输入您要选择的操作:");
	scanf("%d",&a);//选择功能
	switch(a)
	{
	case 1:
		user_select();
		break;
	case 2:
		userregister();
		break;
	case 3:
		search_menu(0);
		break;
	case 4:
		adminlogin();
		break;
	default:
		xuanzhe();
	}
}
void xuanzhe()
{
	int result=MessageBox(NULL,TEXT("您是否要退出系统"),TEXT("提示"),MB_ICONINFORMATION|MB_YESNO);//弹出提示窗口
	switch(result)
	{
	case IDYES:exit(0);
	case IDNO:
		system("cls");
		menu();
	}
}
void adminlogin()//管理员登陆界面
{
	int n=1;
	char pass[20];
	char in[20];
	FILE *fp;
	if((fp=fopen("adminpassword.txt","r"))==NULL)
	{
		printf("\t\t检测到您未创建管理员账号！\n");
		fclose(fp);
		fp=fopen("adminpassword.txt","w");	
		printf("\t\t账号已为您设置为admin\n");
		printf("\t\t请您为此账号设置密码:");
		getchar();
		gets(pass);
		fprintf(fp,"%s",pass);
		printf("\t\t已经创建,即将重启程序\n");
		//Sleep(3000);
		fclose(fp);
	}
	printf("\t\t用户admin（管理员）您好\n");
	printf("\t\t请输入您的登录密码对系统进行管理：");
	while(n++<=4)//输入密码错误三次退出循环
	{
		fp=fopen("adminpassword.txt","r");
		fscanf(fp,"%s",pass);
		getchar();
		gets(in);
		if(strcmp(in,pass)==0)
		{
			printf("\t\t\t登录成功");
			adminmenu();//密码正确进入管理员菜单
		}
		switch(n)
		{
			case 2:printf("\t\t\t提示请在输入密码前先输入空格\n\t\t\t密码错误请重新输入：\n");break;
			case 3:printf("\t\t\t提示请在输入密码前先输入空格\n\t\t\t密码又错了—_—#,再输：\n");break;
			case 4:printf("\t\t\t提示请在输入密码前先输入空格\n\t\t\t最后一次输入：\n");menu();break;
		}
	}
	fclose(fp);
	menu();//密码错误返回主菜单
}
void adminmenu()//管理员菜单
{
	
	int a;
	system("cls");
	printf("\t\t======================================\n");
	printf("\t\t||\t[1].录入图书信息            ||\n");
	printf("\t\t||\t[2].删除图书信息            ||\n");
	printf("\t\t||\t[3].插入图书信息            ||\n");
	printf("\t\t||\t[4].显示所有图书            ||\n");
	printf("\t\t||\t[5].修改图书信息            ||\n");
	printf("\t\t||\t[6].管理员登出              ||\n");
	printf("\t\t======================================\n");
	printf("\t\t请输入您要选择的操作:");
	scanf("%d",&a);
	switch(a)
	{
	case 1:
		input_book();
		break;
	case 2:
		delbook();
		break;
	case 3:
		insert();
		break;
	case 4:
		display_book();
		break;
	case 5:
		amend();
		break;
	default:
		system("cls");
		menu();
	}
}
void input_book()//载入图书
{
	FILE *fp;
	int i,result;
	int n,k=1000;
	result=MessageBox(NULL,TEXT("现在输入的数据将覆盖以前所有的数据"),TEXT("警告"),MB_ICONINFORMATION|MB_YESNO);
	switch(result)
	{
	case IDYES:
		break;
		adminmenu();
	case IDNO:
		system("cls");
		adminmenu();
	}
	printf("\t\t请输入要载入的书本数：");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		k=k+i;
		sprintf(book[i].name,"%d",k);
		printf("\n\t\t本书编号：%s"book[i].name);
		printf("\n\t\t请输入书名：");
		scanf("%s",book[i].name);
		printf("\n\t\t请输入作者名：");
		scanf("%s",book[i].writer);
		printf("\n\t\t请输入出版社的名字：");
		scanf("%s",book[i].publish);
		printf("\n\t\t请输入出版日期：");
		scanf("%s",book[i].day);
		printf("\n\t\t请输入书本价格：");
		scanf("%d",&book[i].money);
		printf("\n\n\t\t您将载入此书：\n");
		printf("\t\t书本编号：%s\n",book[i].num);
		printf("\t\t书名《%s》\n",book[i].name);
		printf("\t\t作者：%s\n",book[i].writer);
		printf("\t\t出版社：%s\n",book[i].publish);
		printf("\t\t单价：%d 元\n",book[i].money);
		printf("\t\t出版日期：%s\n",book[i].day);
		book[i].book_num=book[i].book_num+1;
		printf("\n\n");
	}
	if((fp=fopen("book_list.txt","w"))==NULL)
	{
		printf("\t\t无法打开文件");
		menu();
	}
	for(i=0;i<n;i++)
		fwrite(&book[i],sizeof(struct book_type),1,fp);
	fclose(fp);
	system("cls");
	adminmenu();//
}
void display_book()//显示所有图书
{
	FILE *fp;
	int i;
	//char read[20];
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		adminmenu();
	}
	for(i=0;(!feof(fp));i++)
	{
		fread(&book[i],sizeof(struct book_type),1,fp);
		printf("\t\t书本编号：%s",book[i].num);
		printf("\t\t书名《%s》\n",book[i].name);
		printf("\t\t作者：%s\n",book[i].writer);
		printf("\t\t出版社：%s\n",book[i].publish);
		printf("\t\t单价：%d 元\n",book[i].money);
		printf("\t\t出版日期：%s\n",book[i].day);
		printf("\t\t库存数目：%d\n",book[i].book_num);
	}
	getchar();//*等待应该加入借书选项*
	getchar();
	system("cls");
	adminmenu();
}
void delbook()//删除图书信息
{
	FILE *fp;
	char num2[20];
	int i,n,j,result;
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		adminmenu();
	}
	for(i=0;(!feof(fp));i++)//获取文件最后的位置结构体
		fread(&book[i],sizeof(struct book_type),1,fp);
	n=i-1;//减去一个要删除的结构体
	fclose(fp);
	printf("\t\t请输入要删除书籍的编号:");
	//getchar();
	gets(num2);
	for(i=0;i<n;i++)
	{
		if(strcmp(book[i].num,num2)==0)
		{
			for(j=i;j<n-1;j++)
				book[j]=book[j+1];
			result=MessageBox(NULL,TEXT("现在将删除数据"),TEXT("警告"),MB_ICONINFORMATION|MB_YESNO);
			switch(result)
			{
			case IDYES:
				if((fp=fopen("book_list.txt","w"))==NULL)
				{
					printf("\t\t无法打开文件");
					menu();
				}
				for(i=0;i<n-1;i++)
					fwrite(&book[i],sizeof(struct book_type),1,fp);
				fclose(fp);
				printf("\n\t\t删除成功,回车键退出");
				getchar();
				adminmenu();
			case IDNO:
				system("cls");
				adminmenu();
			}
		}
	}
	if(i==n)
		printf("\n\t\t无此书");
	printf("\n\t\t回车继续");
	getchar();
	adminmenu();
	
}
void amend()//图书修改。*待完善*                                                             
{
	FILE *fp;
	char num2[20];
	int i,n,result;
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		adminmenu();
	}
	for(i=0;(!feof(fp));i++)
		fread(&book[i],sizeof(struct book_type),1,fp);
	fclose(fp);
	n=i;
	printf("\t\t请输入要修改书籍的编号:");
	getchar();
	gets(num2);
	for(i=0;i<n;i++)
	{
		if(strcmp(book[i].num,num2)==0)
		{
			printf("\t\t请输入书名：");
			scanf("%s",book[i].name);
			printf("\t\t请输入作者名：");
			scanf("%s",book[i].writer);
			printf("\t\t请输入出版社的名字：");
			scanf("%s",book[i].publish);
			printf("\t\t请输入出版日期：");
			scanf("%s",book[i].day);
			printf("\t\t请输入书本价格：");
			scanf("%d",&book[i].money);
			result=MessageBox(NULL,TEXT("现在修改的数据将覆盖以前的数据"),TEXT("警告"),MB_ICONINFORMATION|MB_YESNO);
			switch(result)
			{
			case IDYES:
				if((fp=fopen("book_list.txt","w"))==NULL)
				{
					printf("\t\t无法打开文件");
					menu();
				}
				for(i=0;i<n;i++)
					fwrite(&book[i],sizeof(struct book_type),1,fp);
				fclose(fp);
				printf("\n\t\t修改成功,回车键退出");
				getchar();
				adminmenu();
			case IDNO:
				system("cls");
				adminmenu();
			}
		}
	}
	if(i==n)
		printf("\n\t\t书库里没有编号为%s的图书\n\t\t回车退出!!\n",num2);
	getchar();
	adminmenu();
}
void insert()//待测
{
	FILE *fp;   //char num2[20]
	int i,n,result;
	printf("\t\t请输入要载入的书本数：");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\t\t请赋上本书的编号：");
		scanf("%s",book[i].num);
		printf("\t\t请输入书名：");
		scanf("%s",book[i].name);
		printf("\t\t请输入作者名：");
		scanf("%s",book[i].writer);
		printf("\t\t请输入出版社的名字：");
		scanf("%s",book[i].publish);
		printf("\t\t请输入出版日期：");
		scanf("%s",book[i].day);
		printf("\t\t请输入书本价格：");
		scanf("%d",&book[i].money);
		printf("\t\t您将载入此书：\n");
		printf("\t\t书本编号：%s",book[i].num);
		printf("\t\t书名《%s》\n",book[i].name);
		printf("\t\t作者：%s\n",book[i].writer);
		printf("\t\t出版社：%s\n",book[i].publish);
		printf("\t\t单价：%d 元\n",book[i].money);
		printf("\t\t出版日期：%s\n",book[i].day);
	}
	if((fp=fopen("book_list.txt","a"))==NULL)
	{
		printf("\t\t无法打开文件");
		menu();
	}
	for(i=0;i<n;i++)
	{
		fwrite(&book[i],sizeof(struct book_type),1,fp);
		fprintf(fp,"\n");
	}
	fclose(fp);
	system("cls");
	adminmenu();
}
void usermenu(int x)//读者菜单
{
	int a;
	system("cls");
	printf("\t\t======================================\n");
	printf("\t\t||\t[1].我要借书                ||\n");
	printf("\t\t||\t[2].我要还书                ||\n");
	printf("\t\t||\t[3].我要找书                ||\n");
	printf("\t\t||\t[4].个人中心                ||\n");
	printf("\t\t||\t[5].退出登录                ||\n");
	printf("\t\t======================================\n");
	printf("\t\t请输入您要选择的操作:");
	scanf("%d",&a);
	switch(a)
	{
	case 1:
		borrow(x);
		break;
	case 2:
		give_back(x);
		break;
	case 3:
		borrow(x);
		break;
	case 4:
		personal(x);
		break;
	default:
		menu();
	}
}
void borrow(int x)//借书界面
{
	
	int a;
	system("cls");
	printf("\t\t======================================\n");
	printf("\t\t||\t[1].按编号索书              ||\n");
	printf("\t\t||\t[2].按名称索书              ||\n");
	printf("\t\t||\t[3].按作者索书              ||\n");
	printf("\t\t||\t[4].返回菜单                ||\n");
	printf("\t\t======================================\n");
	printf("\t\t请输入您要选择的操作:");
	scanf("%d",&a);
	switch(a)
	{
	case 1:
		search_num(x);
		break;
	case 2:
		search_name(x);
		break;
	case 3:
		search_writer(x);
		break;
	default:
		usermenu(x);
		break;
	}
}
void search_name(int x)//检索*********//
{
	FILE *fp;
	int i,n,j,result;
	char read[20];
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		usermenu(x);
	}
	for(i=0;(!feof(fp));i++)
		fread(&book[i],sizeof(struct book_type),1,fp);
	n=i;
	fclose(fp);
	printf("\t\t请输入要借书籍的名称:");
	getchar();
	gets(read);
	for(i=0;i<n;i++)
	{
		if(strcmp(book[i].name,read)==0)
		{
			result=MessageBox(NULL,TEXT("是否借出此书"),TEXT("提示"),MB_ICONINFORMATION|MB_YESNO);
			switch(result)
			{
			case IDYES:
				if((fp=fopen("book_list.txt","w"))==NULL)
				{
					printf("\t\t无法打开文件");
					usermenu(x);
				}
				book[i].book_num=book[i].book_num-1;
				if(book[i].book_num<1)
				{
					printf("暂无此书\n");
					book[i].book_num=book[i].book_num+1;
					usermenu(x);
				}
				for(i=0;i<n;i++)
					fwrite(&book[i],sizeof(struct book_type),1,fp);
				fclose(fp);
				readin_inf(book,i,x);
				/* if((fp=fopen("user_inf.txt","r"))==NULL)
				{
					printf("\t\t无法打开文件");
					usermenu();
				}
				for(i=0;(!feof(fp));i++)
					fread(&inf[i],sizeof(struct user_inf),1,fp);
				inf[x].book_num=inf[x].book_num+1;
				if((fp=fopen("book_list.txt","w"))==NULL)
				{
					printf("\t\t无法打开文件");
					menu();
				}
				for(i=0;i<n;i++)
					fwrite(&inf[i],sizeof(struct user_inf),1,fp);
				fclose(fp);
				if((fp=fopen("borrow_list.txt","a"))==NULL)
				{
					printf("\t\t无法打开文件");
					menu();
				}
				stpcpy(list.book_num,book[i].num);
				for(i=0;i<n;i++)
					fwrite(&list,sizeof(borrow_list),1,fp);
				fclose(fp); */
				printf("\n\t\t借书成功,回车键退出");
				getchar();
				usermenu(x);
			case IDNO:
				system("cls");
				usermenu(x);
			}
		}
	}
	if(i==n)
		printf("\n\t\t书库里没有名称为%s的图书\n\t\t回车退出!!\n",read);
	getchar();
	usermenu(x);
}
void search_num(int x)
{
	FILE *fp;
	int i,n,j,result;
	char read[20];
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		usermenu(x);
	}
	for(i=0;(!feof(fp));i++)
		fread(&book[i],sizeof(struct book_type),1,fp);
	n=i;
	fclose(fp);
	printf("\t\t请输入要借书籍的编号:");
	getchar();
	gets(read);
	for(i=0;i<n;i++)
	{
		if(strcmp(book[i].num,read)==0)
		{
			result=MessageBox(NULL,TEXT("是否借出此书"),TEXT("提示"),MB_ICONINFORMATION|MB_YESNO);
			switch(result)
			{
			case IDYES:
				if((fp=fopen("book_list.txt","w"))==NULL)
				{
					printf("\t\t无法打开文件");
					usermenu(x);
				}
				book[i].book_num=book[i].book_num-1;
				if(book[i].book_num<1)
				{
					printf("暂无此书\n");
					book[i].book_num=book[i].book_num-1;
					usermenu(x);
				}
				for(i=0;i<n;i++)
					fwrite(&book[i],sizeof(struct book_type),1,fp);
				fclose(fp);
				readin_inf(book,i,x);
				printf("\n\t\t借书成功,回车键退出");
				getchar();
				usermenu(x);
			case IDNO:
				system("cls");
				usermenu(x);
			}
		}
	}
	if(i==n)
		printf("\n\t\t书库里没有编号为%s的图书\n\t\t回车退出!!\n",read);
	getchar();
	usermenu(x);
}
void search_writer(int x)//检索*******//
{
	FILE *fp;
	int i,n,j,result;
	char read[20],num2[20];
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		usermenu(x);
	}
	for(i=0;(!feof(fp));i++)
		fread(&book[i],sizeof(struct book_type),1,fp);
	n=i;
	fclose(fp);
	printf("\t\t请输入作者名:");
	getchar();
	gets(read);
	printf("\t\t搜索到以下图书");
	for(i=0;i<n;i++)
	{
		if(strcmp(book[i].writer,read)==0)
		{
			printf("\t\t书本编号：%s",book[i].num);
			printf("\t\t书名《%s》\n",book[i].name);
			printf("\t\t作者：%s\n",book[i].writer);
			printf("\t\t出版社：%s\n",book[i].publish);
			printf("\t\t单价：%d 元\n",book[i].money);
			printf("\t\t出版日期：%s\n",book[i].day);
			printf("\t\t库存数目：%d\n",book[i].book_num);
			printf("\n\t\t====================================\n");
		}
	}
	printf("请输入要借取书本编号");
	getchar();
	gets(num2);
	for(i=0;i<n;i++)
	{
		if(strcmp(book[i].num,num2)==0)
		{
			result=MessageBox(NULL,TEXT("是否借出此书"),TEXT("提示"),MB_ICONINFORMATION|MB_YESNO);
			switch(result)
			{
			case IDYES:
				if((fp=fopen("book_list.txt","w"))==NULL)
				{
					printf("\t\t无法打开文件");
					usermenu(x);
				}
				book[i].book_num=book[i].book_num-1;
				if(book[i].book_num<1)
				{
					printf("暂无此书\n");
					book[i].book_num=book[i].book_num-1;
					usermenu(x);
				}
				for(i=0;i<n;i++)
					fwrite(&book[i],sizeof(struct book_type),1,fp);
				fclose(fp);
				printf("\n\t\t借书成功,回车键退出");
				getchar();
				usermenu(x);
			case IDNO:
				system("cls");
				usermenu(x);
			}
		}
	}
}
void search_menu(int x)//检索界面
{
	int a;
	system("cls");
	printf("\t\t======================================\n");
	printf("\t\t||\t[1].按编号索书              ||\n");
	printf("\t\t||\t[2].按名称索书              ||\n");
	printf("\t\t||\t[3].按作者索书              ||\n");
	printf("\t\t||\t[4].返回菜单                ||\n");
	printf("\t\t======================================\n");
	printf("\t\t请输入您要选择的操作:");
	scanf("%d",&a);
	switch(a)
	{
	case 1:
		search_num(x);
		break;
	case 2:
		search_name(x);
		break;
	case 3:
		search_writer(x);
		break;
	case 4:
		usermenu(x);
	}
}
void give_back(int x)
{
	FILE *fp;
	int i,n,j,result;
	char read[20];
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		usermenu(x);
	}
	for(i=0;(!feof(fp));i++)
		fread(&book[i],sizeof(struct book_type),1,fp);
	n=i;
	fclose(fp);
	printf("\t\t请输入要归还的书籍的编号:");
	getchar();
	gets(read);
	for(i=0;i<n;i++)
	{
		if(strcmp(book[i].num,read)==0)
		{
			result=MessageBox(NULL,TEXT("确认是否归还此书"),TEXT("提示"),MB_ICONINFORMATION|MB_YESNO);
			switch(result)
			{
			case IDYES:
				if((fp=fopen("book_list.txt","w"))==NULL)
				{
					printf("\t\t无法打开文件");
					usermenu(x);
				}
				book[i].book_num=book[i].book_num+1;
				for(i=0;i<n;i++)
					fwrite(&book[i],sizeof(struct book_type),1,fp);
				fclose(fp);
				printf("\n\t\t还成功,回车键退出");
				getchar();
				usermenu(x);
			case IDNO:
				system("cls");
				usermenu(x);
			}
		}
	}
	if(i==n)
		printf("\n\t\t书库里没有编号为%s的图书\n\t\t回车退出!!\n",read);
	getchar();
	adminmenu();
}
void user_select()
{
	int a;
	system("cls");
	printf("\t\t======================================\n");
	printf("\t\t||\t[1].我已经拥有账号          ||\n");
	printf("\t\t||\t[2].我没有账号              ||\n");
	printf("\t\t||\t[3].返回菜单                ||\n");
	printf("\t\t======================================\n");
	printf("\t\t请输入您要选择的操作:");
	scanf("%d",&a);
	switch(a)
	{
	case 1:
		userlog();
		break;
	case 2:
		userregister();
		break;
	case 4:
		menu();
	}
}
void userlog()//未完成
{
	int n=1,i;
	char name2[20],pass[20],in[20];
	FILE *fp;
	if((fp=fopen("user.txt","r"))==NULL)
	{
		printf("无法打开文件\n");
		menu();
	}
	for(i=0;!(feof(fp));i++)
		fread(&use[i],sizeof(struct user_type),1,fp);
	n=i;
	printf("\\n\t\t请输入您的账号：");
	gets(name2);
	for(i=0;i<n;i++)
	{
		if(strcmp(use[i].name,name2)==0)
		{
			strcpy(pass,use[i].password);
			break;
		}
	}
	while(n++<=4)
	{
		printf("\n\t\t请输入您的密码：");
		gets(in);
		if(strcmp(in,pass)==0)
		{
			printf("\t\t\t登录成功");
			usermenu(i);
			break;
		}
		switch(n)
		{
			case 2:printf("\t\t\t密码错误请重新输入：\n");break;
			case 3:printf("\t\t\t密码又错了—_—#,再输：\n");break;
			case 4:printf("\t\t\t最后一次输入：\n");menu();break;
		}
	}
	fclose(fp);
}
void userregister()//未完成
{
	borrow_list list;
	FILE *fp,*p,*fp2;
	int i,n;
	printf("\t\t您好，欢迎注册图书管理系统\n");
	if((fp=fopen("user.txt","a+"))==NULL)
	{
		printf("\t\t无法打开文件");
		menu();
	}
	if((p=fopen("user_inf.txt","a+"))==NULL)
	{
		printf("\t\t无法打开文件");
		menu();
	}
	if((fp2=fopen("borrow_list.txt","a+"))==NULL)
	{
		printf("\t\t无法打开文件");
		menu();
	}
	for(i=0;(!feof(fp));i++)
		fread(&book[i],sizeof(struct book_type),1,fp);
	printf("\n\t\t请输入您注册的号码：");
	scanf("%s",use[i].num);
	printf("\n\t\t请输入您的用户名：");
	gets(inf[i].name);
	printf("\n\t\t请输入您注册的密码：");
	scanf("%s",use[i].password);
	fwrite(&use[i],sizeof(struct user_type),1,fp);
	fclose(fp);
	strcpy(inf[i].num,use[i].num);
	strcpy(list.num,use[i].num);
	strcpy(list.name,inf[i].name);
	fwrite(&inf[i],sizeof(struct user_inf),1,p);
	fwrite(&list,sizeof(borrow_list),1,fp2);
	fclose(p);
	printf("注册成功！！！\n");
	userlog();
}
void personal(int x)
{
	borrow_list list[20];
	FILE *fp;
	int i,n,j,k,a;
	if((fp=fopen("user_inf.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n回车返回");
		getchar();
		menu();
	}
	for(i=0;(!feof(fp));i++)
		fread(&inf[i],sizeof(struct user_inf),1,fp);
	printf("\t\t欢迎您用户——%s",inf[x].name);
	printf("\t\t您目前的借阅信息如下：");
	printf("\t\t您目前借出书籍数%d",inf[x].book_num);
	printf("\t\t借阅书如下：");
	if((fp=fopen("borrow_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n回车返回");
		getchar();
		menu();
	}
	for(i=0;(!feof(fp));i++)
		fread(&list[i],sizeof(borrow_list),1,fp);
	i=n;
	if((fp=fopen("book_list.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n回车返回");
		getchar();
		menu();
	}
	for(j=0;(!feof(fp));j++)
		fread(&book[i],sizeof(struct book_type),1,fp);
	k=j;
	for(i=0;i<n;i++)
	{
		if(strcmp(inf[x].num,list[i].user_num)==0)
			for(j=0;j<k;j++)
				if(strcmp(book[j].num,list[i].user_num)==0)
				{
					printf("\t\t书本编号：%s\n",book[j].num);
					printf("\t\t书名《%s》\n",book[j].name);
					printf("\t\t作者：%s\n",book[j].writer);
					printf("\t\t出版社：%s\n",book[j].publish);
					printf("\t\t单价：%d 元\n",book[j].money);
					printf("\t\t出版日期：%s\n",book[j].day);
					printf("\t=================================\n")
				}
	}
	printf("进入修改个人信息界面请输入[1]\n密码修改[2]\n返回[3]");
	scanf("%d",&a);
	switch(a)
	{
		case 1:inf_amend(x);
		case 2:password_amend(x);
		case 3:usermenu(x);
	}
}
void inf_amend(int x)
{
	FILE *fp;
	char num2[20];
	int i,n,result;
	if((fp=fopen("user_inf.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		adminmenu();
	}
	for(i=0;(!feof(fp));i++)
		fread(&inf[i],sizeof(struct user_inf),1,fp);
	fclose(fp);
	printf("请修改用户名：");
	scanf("%s",inf[x].name);
	printf("请修改学号：");
	printf("请修改班级：");
	result=MessageBox(NULL,TEXT("现在修改的数据将覆盖以前的数据"),TEXT("警告"),MB_ICONINFORMATION|MB_YESNO);
	switch(result)
	{
	case IDYES:
		if((fp=fopen("user_inf.txt","w"))==NULL)
		{
			printf("\t\t无法打开文件");
			menu();
		}
		for(i=0;i<n;i++)
		fwrite(&inf[i],sizeof(struct user_inf),1,fp);
		fclose(fp);
		printf("\n\t\t修改成功,回车键退出");
		getchar();
		usermenu(x);
	case IDNO:
		system("cls");
		usermenu(x);
	}
}
void password_amend(int x)
{
	FILE *fp;
	char num2[20];
	int i,n,result;
	if((fp=fopen("user.txt","r"))==NULL)
	{
		printf("\t\t无法打开文件\n");
		printf("\t\t回车继续");
		getchar();
		getchar();
		adminmenu();
	}
	for(i=0;(!feof(fp));i++)
		fread(&inf[i],sizeof(struct user_inf),1,fp);
	fclose(fp);
	printf("请修改的秘码：");
	gets(use[x].password);
	result=MessageBox(NULL,TEXT("现在将修改密码"),TEXT("警告"),MB_ICONINFORMATION|MB_YESNO);
	switch(result)
	{
	case IDYES:
		if((fp=fopen("user_inf.txt","w"))==NULL)
		{
			printf("\t\t无法打开文件");
			menu();
		}
		for(i=0;i<n;i++)
			fwrite(&use[i],sizeof(struct user_type),1,fp);
		fclose(fp);
		printf("\n\t\t修改成功,回车键返回");
		getchar();
		usermenu(x);
	case IDNO:
		system("cls");
		usermenu(x);
	}
}
