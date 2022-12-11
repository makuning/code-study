#define _CRT_SECURE_NO_WARNINGS 1

// �����治�����ĳ�����е��ԣ���Ҫ�Լ���д���ֺ�����
// ����ջpush()����ջpop()��ȡͷԪ��top_stack��
// ��ʾ���ɽ�exp_reduced()����Ϊ��������
// �������ʽ��ֵ��������������㷨���ٶ����ն�����ı��ʽ���﷨����
#include <string.h>
#include <stdio.h>
#include<malloc.h>

#define LEN 10

char op[6];
typedef int elemtype;
typedef struct sqstacktp {
	elemtype elems[LEN];
	int top;
}sqstacktp;

void push(sqstacktp* stack, elemtype elem) {
	if (stack->top >= LEN-1) return;
	elemtype* elems = (stack->elems);
	elems[stack->top + 1] = elem;
	stack->top++;
	return;
}

elemtype pop(sqstacktp* stack) {
	elemtype* elems = stack->elems;
	return elems[stack->top--];
}

void init(sqstacktp* stack) {
	*(stack->elems) = { 0 };
	stack->top = 0;
}

elemtype top_stack(sqstacktp* stack) {
	elemtype* elems = stack->elems;
	return elems[stack->top];
}

int precedence(char ch)
{
	int z = 0;
	switch (ch)
	{
		case '+':
			z = 1; break;
		case '-':
			z = 1; break;
		case '*':
			z = 2; break;
		case '/':
			z = 2; break;
		case '#':
			z = 0; break;
		default:
			printf("error!\n");
	}
	return z;
}

int operate(int x, char ch, int y)
{
	int z = 0;
	switch (ch)
	{
		case '+':
			z = x + y; break;
		case '-':
			z = x - y; break;
		case '*':
			z = x * y; break;
		case '/':
			z = x / y; break;
		default:
			printf("error!\n");
	}
	return z;
}

elemtype  exp_reduced()
{
	char w;
	int x, y, z;
	sqstacktp* OPTR = (sqstacktp*) malloc(sizeof(sqstacktp));
	sqstacktp* OPND = (sqstacktp*) malloc(sizeof(sqstacktp));
	strcpy(op, "+-*/#");   // opΪ���������
	init(OPTR);
	push(OPTR, '#');
	init(OPND);
	//ջ��ʼ�������������ջ��ջ��ѹ����ʽ���������ַ���#��
	w = getchar();        //���ն˶���һ���ַ�
	while (!((w == '#') && (top_stack(OPTR) == '#')))
	{
		if (!strchr(op, w))
		{
			push(OPND, w);
			w = getchar();    //��������������ջ
		}
		else if (precedence(w) > precedence(top_stack(OPTR))) //�Ƚ�������
		{
			push(OPTR, w);
			w = getchar();
		}
		else
		{
			char theta;
			theta = pop(OPTR);  //����ջ�������
			y = pop(OPND);
			x = pop(OPND);   //������������������
			z = operate(x, theta, y);    //��������x��y
			push(OPND, z);     //��������ѹ�������ջ
		}
	}
	return(top_stack(OPND));  //�Ӳ�����ջ��ȡ�����ʽ����������
}

int main() {
	elemtype result = exp_reduced();
	printf("%d",result);
	return 0;
}