#include <iostream>
#include <string>
#include <set>

using namespace std;

int main()
{
	string input;
	set<string> list;
	int count=0;

	while ( !cin.eof() ) {
		getline(cin,input);
		if(input.substr(0,1)=="+"){
			list.insert(input.substr(1));
		}else if(input.substr(0,1)=="-"){
			list.erase(input.substr(1));
		}else{
			int findColon=input.find(":")+1;
			string text=input.substr(findColon);
			count += text.length() * list.size();
		}
	}
	cout << count << endl;

	return 0;
}

