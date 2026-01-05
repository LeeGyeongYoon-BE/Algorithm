class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String starNumber = phone_number.substring(phone_number.length() - 4);
        answer += "*".repeat(phone_number.length() - 4);
        
        answer += starNumber;
        return answer;
    }
}