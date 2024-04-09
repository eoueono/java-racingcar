package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        Scanner sc = new Scanner(System.in);
        String[] car = sc.nextLine().split(",");
        System.out.printf("시도할 회수는 몇회인가요?\n");
        int num = sc.nextInt();
        int[] position = new int[car.length];
        int max = 0;

        System.out.printf("실행 결과\n");
        for(int i=0; i<num; i++){
            for(int j=0; j<car.length; j++) {
                int rand = Randoms.pickNumberInRange(0, 9);
                if (rand >= 4){
                    position[j]++;
                    if(position[j] > max) max = position[j];
                }
                System.out.println(car[j] + " : " + "-".repeat(position[j]));
            }
            System.out.println();
        }
        String res = "";
        for(int i=0; i<car.length; i++){
            if(position[i] == max){
                if("".equals(res)) res += car[i];
                else res += ", " + car[i];
            }
        }
        System.out.printf("최종 우승자 : %s", res);
    }
}
