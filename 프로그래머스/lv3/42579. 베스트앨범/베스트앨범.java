import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> map = new HashMap<>();
        for(int i = 0 ; i < genres.length; i++){
            if(!map.containsKey(genres[i]))
                map.put(genres[i], new ArrayList<>());
            List<Song> list = map.get(genres[i]);
            list.add(new Song(i, plays[i]));
        }
        List<Integer> answer = new ArrayList<>();

        List<List<Song>> list = new ArrayList<>(map.values());
        list.sort((o1,o2)->{
            int sum1 = 0, sum2 =0;
            for(Song song : o1)
                sum1 += song.plays;

            for(Song song : o2)
                sum2 += song.plays;

            return sum2 - sum1;
        });

        for(int i = 0 ; i < list.size() ; i++){
            list.get(i).sort((o1,o2)->o2.plays-o1.plays);
            answer.add(list.get(i).get(0).idx);
            if(list.get(i).size() > 1)
                answer.add(list.get(i).get(1).idx);
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static class Song{
        int idx;
        int plays;

        public Song(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }
}