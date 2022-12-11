#define _CRT_SECURE_NO_WARNINGS 1

// 二、将下列单链表的基本操作代码进行运行
// 1、将运行结果截图 ；
// 2、对程序中的每一个函数说明它的作用。

#include<iostream>
#include<string>

using namespace std;
struct Data   //数据结点类型
{
    string key;  //关键字
    string name;
    int age;
};
struct CLType          //定义链表结构
{
    Data nodeData;
    CLType* nextNode;
};

/* 在某个节点后面增加节点
 * head 被插入节点的指针
 * nodeData 需要插入的节点的数据
 * return 返回插入节点指针，失败返回空
 */
CLType* CLAddEnd(CLType* head, Data nodeData);

/* 在某个节点前面增加节点
 * head 被插入节点的指针
 * nodeData 需要插入的节点的数据
 * return 返回插入节点指针，失败则返回空
 */
CLType* CLAddFirst(CLType* head, Data nodeData);

/* 查找单链表第k个节点
 * head 链表头指针
 * k 第几个节点
 * return 返回节点指针
 */
CLType* CLFindNodeNum(CLType* head, int k);

/* 通过节点数据的名字查找节点
 * head 链表头指针
 * name 需要查找的节点的数据中的名字
 * return 返回查找到的节点指针，没有则为空
 */
CLType* CLFindNodeName(CLType* head, string name);

/* 在整个链表指定位置插入节点
 * head 链表头指针
 * k 在哪个位置插入
 * nodeData 插入节点的数据
 * return 链表头指针
 */
CLType* CLInsertNode(CLType* head, int k, Data nodeData);

/* 通过节点数据中的名字删除节点
 * head 链表头指针
 * name 需要删除的节点的数据中的名字
 * reaturn 是否删除，1 是，0 否
 */
int CLDeleteNode(CLType* head, string name);

/* 链表长度
 * head 链表头指针
 * return 链表长度
 */
int CLLength(CLType* head);

/* 控制台打印整个链表
 * head 链表头指针
 */
void CLAllNode(CLType* head);


/* 程序入口*/
int main()
{
    CLType* node, * head = NULL;
    Data nodeData;
    string name;
    int k;
    cout << "请先输入链表中的数据，格式为：学号，姓名，年龄（年龄为0时停止输入）" << endl;
    while (1)
    {
        cin >> nodeData.key >> nodeData.name >> nodeData.age;
        if (nodeData.age == 0)break;
        head = CLAddEnd(head, nodeData);  //在链表的尾部添加结点
    }
    CLAllNode(head);     //显示所有的结点
    //演示在头部插入数据
    cout << "请输入一个结点，并在链表的头部插入" << endl;
    cin >> nodeData.key >> nodeData.name >> nodeData.age;
    head = CLAddFirst(head, nodeData);
    CLAllNode(head);
    //演示在中间位置插入一个数据
    cout << "请输入一个在链表内部插入的结点：" << endl;
    cin >> nodeData.key >> nodeData.name >> nodeData.age;
    cout << "请输入插入点的位置：";
    cin >> k;
    head = CLInsertNode(head, k, nodeData);
    CLAllNode(head);
    //演示按照序号查询数据
    cout << "请输入按照结点查询的一个结点序号：";
    cin >> k;
    node = CLFindNodeNum(head, k);
    cout << "您所查询的结点是：" << endl;
    cout << "key:" << node->nodeData.key << ",name:" << node->nodeData.name << ",age:" << node->nodeData.age << endl;
    //演示按照姓名查询数据
    cout << "请输入一个按照姓名查询的一个同学的姓名：";
    cin >> name;
    node = CLFindNodeName(head, name);
    cout << "您所查询的结点是：" << endl;
    cout << "key:" << node->nodeData.key << ",name:" << node->nodeData.name << ",age:" << node->nodeData.age << endl;
    //演示删除数据信息
    cout << "请输入结点中的一个同学中的名字，系统会删除他的信息：";
    cin >> name;
    if (CLDeleteNode(head, name))cout << "数据删除成功！" << endl;
    CLAllNode(head);
    return 0;
}

CLType* CLAddEnd(CLType* head, Data nodeData)
{
    CLType* node, * htemp;
    if (!(node = new CLType))
    {
        cout << "分配内存失败！" << endl;  //分配内存失败
        return NULL;
    }
    else
    {
        node->nodeData = nodeData;         //保存结点数据
        node->nextNode = NULL;   //设置结点指针为空，即作为表尾
        if (head == NULL)   //当链表是空表的时候
        {
            head = node;
            return head;
        }
        htemp = head;
        while (htemp->nextNode != NULL) //查找链表的末尾
        {
            htemp = htemp->nextNode;
        }
        htemp->nextNode = node;
        return head;
    }
}

CLType* CLAddFirst(CLType* head, Data nodeData)
{
    CLType* node;
    if (!(node = new CLType))
    {
        cout << "分配内存失败" << endl;
        return NULL;
    }
    else
    {
        node->nodeData = nodeData;  //保存结点数据
        node->nextNode = head;  //指向头指针所指向的指针
        head = node;   //头指针指向新增结点
        return head;
    }
}

CLType* CLFindNodeNum(CLType* head, int k)
{
    CLType* htemp;
    int i = 1;
    htemp = head;    //保存链表头指针
    for (i = 1; i < k && htemp; i++)   //找到该结点
    {
        htemp = htemp->nextNode;
    }
    return htemp;     //返回指向第k个结点的指针
}

CLType* CLFindNodeName(CLType* head, string name)
{
    CLType* htemp;
    htemp = head;    //保存链表头指针
    while (htemp)
    {
        if (htemp->nodeData.name == name) //当结点关键字和传入关键字相同
        {
            return htemp;  //返回该结点指针
        }
        htemp = htemp->nextNode;
    }
    return NULL;
}

CLType* CLInsertNode(CLType* head, int k, Data nodeData)
{
    CLType* node, * nodetemp;
    if (!(node = new CLType))   //申请结点
    {
        cout << "申请内存失败" << endl;
        return NULL;
    }
    else
    {
        node->nodeData = nodeData;  //保存结点中的数据
        nodetemp = CLFindNodeNum(head, k - 1);    //通过按照结点序号查找函数找到插入点前一个结点（关键结点）
        if (nodetemp)
        {
            node->nextNode = nodetemp->nextNode;  //插入的结点指向关键结点的下一个节点
            nodetemp->nextNode = node;    //关键结点指向插入点
        }
        else
        {
            cout << "没有找到正确的插入位置" << endl;
            delete node;
        }
    }
    return head;      //返回头指针
}

int CLDeleteNode(CLType* head, string name)
{
    CLType* node, * htemp;    //node用于删除结点的前一个结点
    htemp = head;
    node = head;
    while (htemp)
    {
        if (htemp->nodeData.name == name)             //找到关键字，执行删除操作
        {
            node->nextNode = htemp->nextNode;  //使前一结点指向当前节点的下一结点
            delete htemp;   //释放该结点的空间（即，删除了结点）
            return 1;
        }
        else
        {
            node = htemp;   //指向当前节点
            htemp = htemp->nextNode;  //指向下一个结点
        }
    }
    return 0;     //删除失败
}

int CLLength(CLType* head)
{
    CLType* htemp;
    int Len = 0;
    htemp = head;
    while (htemp)     //遍历整个数组
    {
        Len++;     //累加结点的数量
        htemp = htemp->nextNode;    //处理下一个结点
    }
    return Len;
}

void CLAllNode(CLType* head)
{
    CLType* htemp;
    Data nodeData;
    htemp = head;
    cout << "链表长度为：" << CLLength(head) << endl;
    while (htemp)     //遍历整个数组
    {
        nodeData = htemp->nodeData;   //获取结点数据
        cout << "key:" << nodeData.key << ",name:" << nodeData.name << ",age:" << nodeData.age << endl;
        htemp = htemp->nextNode;    //处理下一个结点
    }
}