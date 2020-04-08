import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance cannot be less than 0");
        }
        if (timeLimit < 0 ){
          throw new IllegalArgumentException("The time cannot be a negative");
        }

        var distances = new HashMap<Pod, Double>();

        var winners = new HashSet<Pod>();
        for (var t = 0.0; t < timeLimit; t += timeSlice) {
            for (var pod : racers) {
                var distanceForThisSlice = pod.distanceTraveled(t, t + timeSlice , 1 );
                distances.put(pod,distances.getOrDefault(pod, 0.0) + distanceForThisSlice);
                if (distances.get(pod) >= distance) {
                    winners.add(pod);
                }
            }
            if (winners.isEmpty() != true){
                return winners;
            }
        }
        return winners;
    }
}
