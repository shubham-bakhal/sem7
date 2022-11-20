#include <bits/stdc++.h>

using namespace std;

struct Node
{
	char data;
	int freq;
	Node *left, *right;
	Node(char d, int f)
	{
		left = right = NULL;
		data = d;
		freq = f;
	}
};

void printCodes(Node *root, string str)
{
	if (root == nullptr)
	{
		return;
	}
	if (root->data != '$')
	{
		cout << root->data << ": " << str << endl;
	}
	printCodes(root->left, str + "0");
	printCodes(root->right, str + "1");
}

struct compare
{
	bool operator()(Node *a, Node *b){
		return (a->freq > b->freq);
	}
};

bool comp(Node *a, Node *b){
	return (a->freq > b->freq);
}

void HuffmanCode(char data[], int freq[], int size)
{
	Node *left, *right, *temp;

	priority_queue<Node *, vector<Node *>, compare> pq;

	for (int i = 0; i < size; i++)
	{
		pq.push(new Node(data[i], freq[i]));
	}

	while (pq.size() != 1)
	{
		left = pq.top();
		pq.pop();
		right = pq.top();
		pq.pop();
		temp = new Node('$', left->freq + right->freq);
		temp->left = left;
		temp->right = right;
		pq.push(temp);
	}
	printCodes(pq.top(), "");
}

int main()
{
	char data[] = {'A', 'B', 'C', 'D'};
	int freq[] = {23, 45, 14, 40};
	HuffmanCode(data, freq, 4);
	return 0;
}