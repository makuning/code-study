#define _CRT_SECURE_NO_WARNINGS 1

// ���������е�����Ļ������������������
// 1�������н����ͼ ��
// 2���Գ����е�ÿһ������˵���������á�

#include<iostream>
#include<string>

using namespace std;
struct Data   //���ݽ������
{
    string key;  //�ؼ���
    string name;
    int age;
};
struct CLType          //��������ṹ
{
    Data nodeData;
    CLType* nextNode;
};

/* ��ĳ���ڵ�������ӽڵ�
 * head ������ڵ��ָ��
 * nodeData ��Ҫ����Ľڵ������
 * return ���ز���ڵ�ָ�룬ʧ�ܷ��ؿ�
 */
CLType* CLAddEnd(CLType* head, Data nodeData);

/* ��ĳ���ڵ�ǰ�����ӽڵ�
 * head ������ڵ��ָ��
 * nodeData ��Ҫ����Ľڵ������
 * return ���ز���ڵ�ָ�룬ʧ���򷵻ؿ�
 */
CLType* CLAddFirst(CLType* head, Data nodeData);

/* ���ҵ������k���ڵ�
 * head ����ͷָ��
 * k �ڼ����ڵ�
 * return ���ؽڵ�ָ��
 */
CLType* CLFindNodeNum(CLType* head, int k);

/* ͨ���ڵ����ݵ����ֲ��ҽڵ�
 * head ����ͷָ��
 * name ��Ҫ���ҵĽڵ�������е�����
 * return ���ز��ҵ��Ľڵ�ָ�룬û����Ϊ��
 */
CLType* CLFindNodeName(CLType* head, string name);

/* ����������ָ��λ�ò���ڵ�
 * head ����ͷָ��
 * k ���ĸ�λ�ò���
 * nodeData ����ڵ������
 * return ����ͷָ��
 */
CLType* CLInsertNode(CLType* head, int k, Data nodeData);

/* ͨ���ڵ������е�����ɾ���ڵ�
 * head ����ͷָ��
 * name ��Ҫɾ���Ľڵ�������е�����
 * reaturn �Ƿ�ɾ����1 �ǣ�0 ��
 */
int CLDeleteNode(CLType* head, string name);

/* ������
 * head ����ͷָ��
 * return ������
 */
int CLLength(CLType* head);

/* ����̨��ӡ��������
 * head ����ͷָ��
 */
void CLAllNode(CLType* head);


/* �������*/
int main()
{
    CLType* node, * head = NULL;
    Data nodeData;
    string name;
    int k;
    cout << "�������������е����ݣ���ʽΪ��ѧ�ţ����������䣨����Ϊ0ʱֹͣ���룩" << endl;
    while (1)
    {
        cin >> nodeData.key >> nodeData.name >> nodeData.age;
        if (nodeData.age == 0)break;
        head = CLAddEnd(head, nodeData);  //�������β����ӽ��
    }
    CLAllNode(head);     //��ʾ���еĽ��
    //��ʾ��ͷ����������
    cout << "������һ����㣬���������ͷ������" << endl;
    cin >> nodeData.key >> nodeData.name >> nodeData.age;
    head = CLAddFirst(head, nodeData);
    CLAllNode(head);
    //��ʾ���м�λ�ò���һ������
    cout << "������һ���������ڲ�����Ľ�㣺" << endl;
    cin >> nodeData.key >> nodeData.name >> nodeData.age;
    cout << "�����������λ�ã�";
    cin >> k;
    head = CLInsertNode(head, k, nodeData);
    CLAllNode(head);
    //��ʾ������Ų�ѯ����
    cout << "�����밴�ս���ѯ��һ�������ţ�";
    cin >> k;
    node = CLFindNodeNum(head, k);
    cout << "������ѯ�Ľ���ǣ�" << endl;
    cout << "key:" << node->nodeData.key << ",name:" << node->nodeData.name << ",age:" << node->nodeData.age << endl;
    //��ʾ����������ѯ����
    cout << "������һ������������ѯ��һ��ͬѧ��������";
    cin >> name;
    node = CLFindNodeName(head, name);
    cout << "������ѯ�Ľ���ǣ�" << endl;
    cout << "key:" << node->nodeData.key << ",name:" << node->nodeData.name << ",age:" << node->nodeData.age << endl;
    //��ʾɾ��������Ϣ
    cout << "���������е�һ��ͬѧ�е����֣�ϵͳ��ɾ��������Ϣ��";
    cin >> name;
    if (CLDeleteNode(head, name))cout << "����ɾ���ɹ���" << endl;
    CLAllNode(head);
    return 0;
}

CLType* CLAddEnd(CLType* head, Data nodeData)
{
    CLType* node, * htemp;
    if (!(node = new CLType))
    {
        cout << "�����ڴ�ʧ�ܣ�" << endl;  //�����ڴ�ʧ��
        return NULL;
    }
    else
    {
        node->nodeData = nodeData;         //����������
        node->nextNode = NULL;   //���ý��ָ��Ϊ�գ�����Ϊ��β
        if (head == NULL)   //�������ǿձ��ʱ��
        {
            head = node;
            return head;
        }
        htemp = head;
        while (htemp->nextNode != NULL) //���������ĩβ
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
        cout << "�����ڴ�ʧ��" << endl;
        return NULL;
    }
    else
    {
        node->nodeData = nodeData;  //����������
        node->nextNode = head;  //ָ��ͷָ����ָ���ָ��
        head = node;   //ͷָ��ָ���������
        return head;
    }
}

CLType* CLFindNodeNum(CLType* head, int k)
{
    CLType* htemp;
    int i = 1;
    htemp = head;    //��������ͷָ��
    for (i = 1; i < k && htemp; i++)   //�ҵ��ý��
    {
        htemp = htemp->nextNode;
    }
    return htemp;     //����ָ���k������ָ��
}

CLType* CLFindNodeName(CLType* head, string name)
{
    CLType* htemp;
    htemp = head;    //��������ͷָ��
    while (htemp)
    {
        if (htemp->nodeData.name == name) //�����ؼ��ֺʹ���ؼ�����ͬ
        {
            return htemp;  //���ظý��ָ��
        }
        htemp = htemp->nextNode;
    }
    return NULL;
}

CLType* CLInsertNode(CLType* head, int k, Data nodeData)
{
    CLType* node, * nodetemp;
    if (!(node = new CLType))   //������
    {
        cout << "�����ڴ�ʧ��" << endl;
        return NULL;
    }
    else
    {
        node->nodeData = nodeData;  //�������е�����
        nodetemp = CLFindNodeNum(head, k - 1);    //ͨ�����ս����Ų��Һ����ҵ������ǰһ����㣨�ؼ���㣩
        if (nodetemp)
        {
            node->nextNode = nodetemp->nextNode;  //����Ľ��ָ��ؼ�������һ���ڵ�
            nodetemp->nextNode = node;    //�ؼ����ָ������
        }
        else
        {
            cout << "û���ҵ���ȷ�Ĳ���λ��" << endl;
            delete node;
        }
    }
    return head;      //����ͷָ��
}

int CLDeleteNode(CLType* head, string name)
{
    CLType* node, * htemp;    //node����ɾ������ǰһ�����
    htemp = head;
    node = head;
    while (htemp)
    {
        if (htemp->nodeData.name == name)             //�ҵ��ؼ��֣�ִ��ɾ������
        {
            node->nextNode = htemp->nextNode;  //ʹǰһ���ָ��ǰ�ڵ����һ���
            delete htemp;   //�ͷŸý��Ŀռ䣨����ɾ���˽�㣩
            return 1;
        }
        else
        {
            node = htemp;   //ָ��ǰ�ڵ�
            htemp = htemp->nextNode;  //ָ����һ�����
        }
    }
    return 0;     //ɾ��ʧ��
}

int CLLength(CLType* head)
{
    CLType* htemp;
    int Len = 0;
    htemp = head;
    while (htemp)     //������������
    {
        Len++;     //�ۼӽ�������
        htemp = htemp->nextNode;    //������һ�����
    }
    return Len;
}

void CLAllNode(CLType* head)
{
    CLType* htemp;
    Data nodeData;
    htemp = head;
    cout << "������Ϊ��" << CLLength(head) << endl;
    while (htemp)     //������������
    {
        nodeData = htemp->nodeData;   //��ȡ�������
        cout << "key:" << nodeData.key << ",name:" << nodeData.name << ",age:" << nodeData.age << endl;
        htemp = htemp->nextNode;    //������һ�����
    }
}