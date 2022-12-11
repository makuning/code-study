#define _CRT_SECURE_NO_WARNINGS 1

// 将下面不完整的程序进行调试，需要自己编写部分函数，
// 如入栈push()、出栈pop()、取头元素top_stack。
// 提示：可将exp_reduced()改造为主函数。
// 算术表达式求值的运算符优先数算法。假定从终端输入的表达式无语法错误
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
	strcpy(op, "+-*/#");   // op为运算符集合
	init(OPTR);
	push(OPTR, '#');
	init(OPND);
	//栈初始化，并在运算符栈的栈底压入表达式左边虚设的字符“#”
	w = getchar();        //从终端读入一个字符
	while (!((w == '#') && (top_stack(OPTR) == '#')))
	{
		if (!strchr(op, w))
		{
			push(OPND, w);
			w = getchar();    //操作数进操作数栈
		}
		else if (precedence(w) > precedence(top_stack(OPTR))) //比较优先数
		{
			push(OPTR, w);
			w = getchar();
		}
		else
		{
			char theta;
			theta = pop(OPTR);  //弹出栈顶运算符
			y = pop(OPND);
			x = pop(OPND);   //连续弹出两个操作数
			z = operate(x, theta, y);    //进行运算xθy
			push(OPND, z);     //将运算结果压入操作数栈
		}
	}
	return(top_stack(OPND));  //从操作数栈顶取出表达式运算结果返回
}

int main() {
	elemtype result = exp_reduced();
	printf("%d",result);
	return 0;
}