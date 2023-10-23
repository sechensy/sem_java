class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        StringBuilder answer = new StringBuilder();
        String[] params = PARAMS.replaceAll("[{}]","").
                replaceAll(":", ",").replaceAll("\"", "").
                replaceAll(" ","").split(",");
        answer.append(QUERY);
        for (int j = 0; j < params.length / 4; j += 2){
            int count = 0;
            for (int i = 0; i < params.length - 1; i +=2){
                if (params[i+1].equals("null")){
                    continue;
                }
                else {
                    answer.append(params[i]);
                    answer.append("='");
                    answer.append(params[i+1]);
                    answer.append("'");
                    count++;
                }
                if (count != 0) answer.append(" and ");
                count = 0;
            }
            answer.delete(answer.lastIndexOf(" and "), answer.lastIndexOf(" "));

        }
        return answer;
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Main{
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"null\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        }
        else{
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}