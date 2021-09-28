package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

//성수의 비밀번호 공격
public class Solution_6026 {

    static int T;
    static int N, M;
    static int MOD = 1_000_000_007; //= 1000000007
    static StringBuilder output = new StringBuilder();
    
    static long[] fac;
    // 매번 동일한 팩토리얼 계산을 하기 때문에 전처리로 미리 구해놓고 재사용 
    // 정수의 크기가 100 --> 미리 구해둬도 크게 문제가 없음
    static void pre() {
        fac = new long[101];
        fac[0] = fac[1] = 1;
        for(int i=2;i<fac.length;i++) {
            fac[i] = (fac[i-1]*i)%MOD; //우린 어차피 나머지만 찾으니까 미리 나머지 구해주기
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        pre(); // 시작과 동시에 팩토리얼값 채우고 시작
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(input.readLine().trim());
        
        // 테케 돌리기는 여기서 시작
        for(int t =1; t<=T; t++) {
            StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
            M = Integer.parseInt(tokens.nextToken());
            N = Integer.parseInt(tokens.nextToken());
            //입력 완료.
            long tot = solve();
            output.append('#').append(t).append(' ').append(tot).append('\n');
        }
        System.out.println(output);    
    }

    // 전사함수의 개수 구하기
    // m = 키의 개수, n = 비밀번호 자리수
    //함수의 개수 : ∑(-1)^i * kCi *(k-i)^n  
    static long solve() {
        long total = 0;
        for(int i=0; i<=M; i++) {
            long l1 = i%2 == 0?1:-1; //(-1)^i 
            long l2 = nCr(i);
            long l3 = pow(M-i,N);
            long result = ((l1*l2)%MOD*(l3)%MOD)%MOD;
            //MOD 를 한번 더해주면 절대 음수가 나오지 못함
            total = (total+result+MOD)%MOD;
        }
        return total;
    }    

    //nCr --> n개에서 r개를 뽑는 경우의 수 구하기.
    // 		= (n!/((n-r)!*r!) %MOD   ---> n!, n-r! 숫자가 매우 커짐 나머지 연산
    // 		= (n! * ((n-r)!*r!)^(MOD-2))%MOD
    // --> 분수에 있는걸 분자로 올리기 위해 페르마의 소정리 이용
    // n!, n-r!등 중복 계산이 일어남, 테케만큼 팩토리얼 계산할 필요 없음
    static long nCr(int r) {
        if(r==0) {
            return 1;
        }
        long l1 = fac[M];
        long l2 = pow(fac[M-r],MOD-2); //100000005?
        long l3 = pow(fac[r],MOD-2);
         
        return ((l1*l2)%MOD*(l3)%MOD)%MOD;
        
    }    

    //분할정복의 형태로 거듭제곱구하기.
    // a^b
    static long pow(long a, int b) {
        if(b==1) {
            return a;
        }
        long half = pow(a,b/2);
        if(b%2==0) {
            return (half*half)%MOD;
            
        }else {
            //나머지 연산의 분배 법칙
            return ((half*half)%MOD*(a)%MOD)%MOD;
        }
    }

}