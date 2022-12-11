#define _CRT_SECURE_NO_WARNINGS 1


#include <stdio.h>
#include <malloc.h>

#define Maxsize  10 

// 方便更改顺序表数据的数据类型？
typedef int elemtype;

// 顺序表结构
typedef struct
{
	elemtype v[Maxsize];
	int len;
}sqlist;

/* 在指定位置插入数据
 * l 顺序表结构指针
 * i 插入的位置
 * x 插入的顺序
 * return 是否成功，1 是，0 否
 */
int insert(sqlist* l, int i, elemtype x);

/* 删除指定位置的数据
 * l 顺序表结构指针
 * i 删除的位置
 * y 插入的顺序
 * return 是否成功，1 是，0 否
 */
int del(sqlist* l, int i, elemtype* y);

/* 创建顺序表
 * l 顺序表结构指针
 */
void creat(sqlist* l);

/* 打印顺序表
 * l 顺序表结构指针
 */
void prin(sqlist* l);

/* 启动程序 */
int main()
{
	sqlist a;
	int i, x, result;
	creat(&a);
	prin(&a);
	printf("input the insert position and data\n");
	scanf("%d %d", &i, &x);
	result = insert(&a, i, x);
	if (result != 0)
		prin(&a);
	printf("input the delet position \n");
	scanf("%d", &i);
	result = del(&a, i, &x);
	if (result != 0)
		prin(&a);
	printf("the delet data is %d\n", x);

	return 0;
}


int insert(sqlist* L, int i, elemtype x)
/*L为sqlist顺序表类型指针变量,i为插入元素的位序号，x为插入元素的值*/
{
	int j;
	if ((*L).len == Maxsize)             /*判断线性表的存储空间是否已满*/
	{
		printf("溢出！ / n");
		return 0;
	}
	else
		if ((i < 1) || i > (*L).len + 1)       /*检查i值是否超出所允许的范围*/
		{
			printf("插入位置不正确 / n");
			return 0;
		 }	else {
			for (j = (*L).len - 1; j >= i - 1; j--)
				/*将第i个元素和它后面的所有元素均后移一个位置*/
				(*L).v[j + 1] = (*L).v[j];
			(*L).v[i - 1] = x; /* 将新的元素写入到空出的下标为i-1的位置上*/
			(*L).len = (*L).len + 1;          /*线性表的长度增加1*/

			return(1);
		}
}

int del(sqlist* l, int i, elemtype* y)
/*l为sqlist顺序表类型指针变量,i为删除元素的位序号，删除元素的值通过y代出*/
{
	int j;
	if ((i < 1) || (i > (*l).len))         /* 判断i值是否超出所允许的范围*/
	{
		printf("删除位置不正确 / n");
		return (0);
	}
	else
	{
		*y = (*l).v[i - 1];                      /* 把第i个元素赋给*y */
		for (j = i; j < (*l).len; j++)
			/* 把第i个元素后的所有元素依次向前移动一个位置*/
			(*l).v[j - 1] = (*l).v[j];
		(*l).len = (*l).len - 1;                 /* 线性表长度减1*/
		return(1);
	}
}

void creat(sqlist* l)
{
	int x, i;
	printf("input the list data:\n");
	for (i = 0; i < Maxsize; i++)
	{
		scanf("%d", &x);
		if (x == 0) {
			break;
		} else{
			(*l).v[i] = x;
		}
	}
	(*l).len = i;
}

void prin(sqlist* l)
{
	int i;
	printf("the list is :\n");
	for (i = 0; i < (*l).len; i++)
		printf("%d\t", (*l).v[i]);
	printf("\n");
}
