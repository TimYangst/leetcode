#include <iostream>
using namespace std;
class A
{
public:
	A(int a)
	{
		member = a;
		cout<<"construct one"<<endl;
	}
	A(A & parament)
	{
		member = parament.member;
		cout<<"copy construct"<<endl;
	}
	~A()
	{
		cout<<"release one"<<endl;
	}
	void output()
	{
		cout<<member<<endl;
	}
	A & operator = ( A b){
		member = b.member;
		cout<<"assign called"<<endl;
		return *this;
	}
	friend A operator + (A &a,A &b);

private:
	int member;
};

A g()
{
	A temp(1);
	return temp;
}

A operator + (A &a,A &b)
{
	a.member += b.member;
	return a;                     //结果1(测试2)  
	// return A(a.member);           //结果2(测试2)   
}
//
//void main()         
//{
//
//	A a1 =
//		g();      //测试1--跟踪整个过程对象a未调用构造与析构函数?
//
//	A a(8);
//	A b(a);
//	a =
//		b 
//		+ 
//		A(7);   //测试2--跟踪整个过程,对于结果2:貌似友员函数在返回时未创建临时(匿名)对象?
//} 