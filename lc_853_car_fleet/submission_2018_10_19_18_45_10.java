

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
    	int fleets = 0;
    	int n = position.length;
    	Car [] cars = new Car[n];
        for (int i = 0; i < n; i++)
        	cars[i] = new Car(position[i], (double)(target - position[i])/speed[i]);
        Arrays.sort(cars);
        for (int i = n - 1; i > 0; i--) {
        	if(cars[i].time < cars[i-1].time) fleets ++;
        	else cars[i-1].time = cars[i].time;
        }
        return fleets + (n == 0 ? 0 : 1);
    }
}

class Car implements Comparable<Car>{
	int position;
	//hypothetical arrive time in case that the car is allowed to overtake another
	double time; 
	public Car(int position, double time){
		this.position = position;
		this.time = time;
	}

	@Override
	public int compareTo(Car another){
		return this.position < another.position ? -1 : 1;
	}
	
}