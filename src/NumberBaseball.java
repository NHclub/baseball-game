import java.util.*;

public class NumberBaseball {
    public static void main(String[] args) {
        // 0~9 사이의 난수 3개 생성, 중복 불가
        // 인덱스, 값 모두 일치하면 S, 위치가 틀렸으면 B 리턴
        // 몇번의 시도 후에 맞췄는지 기록 count 변수 생성
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        Set<Integer> successNuber = new LinkedHashSet<>();

        int maxNum = 10;
        int count = 1;


        
        //중복 불가, 순서 보장 난수 3개 정답 번호 생성
        while (successNuber.size()<3) {
            successNuber.add(rd.nextInt(maxNum));
        }

        List<Integer> successNuberAL = new ArrayList<>(successNuber);

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        while (true) {
            int fullNumber = sc.nextInt();
            String strFull = Integer.toString(fullNumber);
            int[] num = new int[3];
            for(int i = 0; i <3; i++){
                num[i] = Character.getNumericValue(fullNumber.charAt(i));
            }
            int ballCount = 0;
            int strikeCount = 0;
            for (int i = 0; i<3; i++){  //난수 468 입력값153
                if (successNuberAL.contains(num[i])){
                    if (successNuberAL.indexOf(num[i]) == i){
                        strikeCount += 1;
                    } else{
                        ballCount += 1;
                    }
                }
            }
            System.out.println(count + "번째 시도 : " + fullNumber);
            System.out.println(ballCount + "B" + strikeCount + "S");
            count++;

            if (strikeCount == 3){
                System.out.println((count-2)+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}