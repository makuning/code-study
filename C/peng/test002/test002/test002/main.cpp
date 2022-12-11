#define _CRT_SECURE_NO_WARNINGS 1


#include <stdio.h>
#include <malloc.h>

#define Maxsize  10 

// �������˳������ݵ��������ͣ�
typedef int elemtype;

// ˳���ṹ
typedef struct
{
	elemtype v[Maxsize];
	int len;
}sqlist;

/* ��ָ��λ�ò�������
 * l ˳���ṹָ��
 * i �����λ��
 * x �����˳��
 * return �Ƿ�ɹ���1 �ǣ�0 ��
 */
int insert(sqlist* l, int i, elemtype x);

/* ɾ��ָ��λ�õ�����
 * l ˳���ṹָ��
 * i ɾ����λ��
 * y �����˳��
 * return �Ƿ�ɹ���1 �ǣ�0 ��
 */
int del(sqlist* l, int i, elemtype* y);

/* ����˳���
 * l ˳���ṹָ��
 */
void creat(sqlist* l);

/* ��ӡ˳���
 * l ˳���ṹָ��
 */
void prin(sqlist* l);

/* �������� */
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
/*LΪsqlist˳�������ָ�����,iΪ����Ԫ�ص�λ��ţ�xΪ����Ԫ�ص�ֵ*/
{
	int j;
	if ((*L).len == Maxsize)             /*�ж����Ա�Ĵ洢�ռ��Ƿ�����*/
	{
		printf("����� / n");
		return 0;
	}
	else
		if ((i < 1) || i > (*L).len + 1)       /*���iֵ�Ƿ񳬳�������ķ�Χ*/
		{
			printf("����λ�ò���ȷ / n");
			return 0;
		 }	else {
			for (j = (*L).len - 1; j >= i - 1; j--)
				/*����i��Ԫ�غ������������Ԫ�ؾ�����һ��λ��*/
				(*L).v[j + 1] = (*L).v[j];
			(*L).v[i - 1] = x; /* ���µ�Ԫ��д�뵽�ճ����±�Ϊi-1��λ����*/
			(*L).len = (*L).len + 1;          /*���Ա�ĳ�������1*/

			return(1);
		}
}

int del(sqlist* l, int i, elemtype* y)
/*lΪsqlist˳�������ָ�����,iΪɾ��Ԫ�ص�λ��ţ�ɾ��Ԫ�ص�ֵͨ��y����*/
{
	int j;
	if ((i < 1) || (i > (*l).len))         /* �ж�iֵ�Ƿ񳬳�������ķ�Χ*/
	{
		printf("ɾ��λ�ò���ȷ / n");
		return (0);
	}
	else
	{
		*y = (*l).v[i - 1];                      /* �ѵ�i��Ԫ�ظ���*y */
		for (j = i; j < (*l).len; j++)
			/* �ѵ�i��Ԫ�غ������Ԫ��������ǰ�ƶ�һ��λ��*/
			(*l).v[j - 1] = (*l).v[j];
		(*l).len = (*l).len - 1;                 /* ���Ա��ȼ�1*/
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
