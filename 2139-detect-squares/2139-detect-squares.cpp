class DetectSquares {
    
public:
    map<pair<int,int>,int>map;
    DetectSquares() {
    }
    
    void add(vector<int> point) {
        map[{point[0],point[1]}]++;
    }
    
    int count(vector<int> point) {
        int count=0;
        int x=point[0];
        int y=point[1];
        for(auto m:map){
            pair p= m.first;
            if(p.first!=x && p.second!=y && (abs(p.first-x) ==(abs(p.second-y)))){
                int p2 = map[{p.first,p.second}];
                int p3= map[{p.first,y}];
                int p4=map[{x,p.second}];
                count += p2*p3*p4;
            }
        }
        return count;
    }
};

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares* obj = new DetectSquares();
 * obj->add(point);
 * int param_2 = obj->count(point);
 */