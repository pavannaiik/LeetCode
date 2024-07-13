class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot>robots = new ArrayList<>();
        for(int i=0;i<positions.length;i++){
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        Collections.sort(robots,new Comparator<Robot>() {
            public int compare(Robot a, Robot b){
                return a.position - b.position;
            }
        });
        Stack<Robot>stack = new Stack<>();
        for(Robot robot:robots){
            int flag = 1;
            while(!stack.isEmpty() && robot.direction =='L' && stack.peek().direction == 'R'){
                if(stack.peek().health == robot.health){
                    stack.pop();
                    flag =0;
                    break;
                }else if(stack.peek().health > robot.health){
                    stack.peek().health -= 1;
                    flag =0;
                    break;
                }else{
                    stack.pop();
                    robot.health -= 1;
                }
            }
            if(flag ==0){
                continue;
            }else{
                stack.push(robot);
            }
        }
        stack.sort((a,b)->a.index-b.index);
        List<Integer>res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(0,stack.peek().health);
            stack.pop();
        }
        return res;
    }
    
}
class Robot{
        public int position;
        public int health;
        public char direction;
        public int index;

        public Robot(int position, int health, char direction, int index){
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }