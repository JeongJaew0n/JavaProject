package kakao.recuritment2022.Q1;

import java.util.StringTokenizer;
//
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        /* 신고자, 신고한 사람의 형태로 데이터를 저장하면 좋을듯 */
        
        String[] reporters = new String[1000];  // 중복을 검사하기 위한 신고자 이름 배열
        String[] reported = new String[reporters.length];
        int reporterCount = 0;
        int[] reportedCount = new int[1000];

        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            if(!FindRedundantReport(reporters)) {        // 만약 중복 신고가 아니라면
                reporters[reporterCount] =st.nextToken();
                reporterCount++;
            }
        }

        for(int i=0; i < reported.length; i++){
            if(FindRedundantReport(reported)) {
                reportedCount[i]++;
            }
        }

        return answer;
    }

    /* 중복 검사 */
    private boolean FindRedundantReport(String[] reporter){

        for (int i = 0; i < reporter.length; i++) {

        }
        return false;
    }

    class ReportList {
        // 중복검사끝났어 이제 신고한사람, 신고 받은사람 다 가려졌음.
        // 신고 받은 사람은 신고를 몇 번 받았는지
        String id;
        int reportedCount = 0;

        ReportList(String id) {
            if(id == null) {

            }
        }

        public void addReportedCount() {

        }
    }

}


