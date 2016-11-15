package info.androidhive.navigationdrawer.common;

/**
 * Created by apple on 16/10/8.
 */

public class MyConfig {
    public static final String PREFERENCE_NAME = "its_cetc";
    public static final String APP_NAME = "ITSApplictaion";

    private static class HTTP_BASE {
        public static final String REALSE_URL = "http://10.111.6.3";
        public static final String TEST_URL = "http://10.111.7.23:8080";
        public static final String EXTRANET_URL = "http://its.cetc-ss.com:9000";
    }
    public static class URLS {
        private static final String BASE_URL = HTTP_BASE.EXTRANET_URL;
//        private static final String BASE_URL = HTTP_BASE.TEST_URL;

        public static final String loginUrl = BASE_URL + "/login!loginApp.ce";
        public static final String logoutUrl = BASE_URL + "/login!logoutApp.ce";
        public static final String oppotunityListsUrl = BASE_URL + "/project!projectForMainList.ce";
        public static final String oppotunityDetailUrl = BASE_URL + "/opportunity!editPageApp.ce";///opportunity!editPage.ce?STATUS=1&PROJECT_ID=        status  =1查看  2编辑 3新增
        public static final String oppotunityDetailProcessUrl = BASE_URL + "/opportunity!projectLogList.ce"; //参数  PROJECT_ID     和常量LOG_TYPE=2
        public static final String oppotunityDetailOpeLogUrl = BASE_URL + "/opportunity!projectLogList.ce"; // 参数  PROJECT_ID     和常量LOG_TYPE=1
        public static final String oppotunityDetailBillPlanUrl = BASE_URL + "/opportunity!commitPlanList.ce"; //PROJECT_ID
        public static final String businessTripListUrl = BASE_URL + "/travel!getTravelList.ce";
        public static final String expensesApproveListUrl = BASE_URL + "/workflow!getMyTaskListView.ce";
        public static final String travelDetailUrl = BASE_URL + "/travel!showApproveTaskViewApp.ce";
        public static final String expenseDetailUrl = BASE_URL + "/expense!approvePageApp.ce";
        public static final String expTrvLogUrl = BASE_URL + "/workflow!getLogByInstanceId.ce";//参数：INSTANCE_ID =    列表返回的字段 --PROC_INST_ID_
        public static final String submitApproveUrl = BASE_URL + "/travel!completeTask.ce";
        public static final String newTravelApplyUrl = BASE_URL + "/travel!saveStartProcess.ce";
        public static final String holidayListsUri = BASE_URL + "/userdayoff!DayOffListApp.ce";//参数：DEPT_ID : 部门ID   USER_NAME 人员名称（模糊查询）
        public static final String vacationInfoUri = BASE_URL + "/userdayoff!UserANL.ce";//DEPT_ID	：部门ID USER_NAME	：请假人名称  YEAR_ ：年份

    }

    public class Const {
        public static final String URL_JSON_OBJECT = "http://api.androidhive.info/volley/person_object.json";
        public static final String URL_JSON_ARRAY = "http://api.androidhive.info/volley/person_array.json";
        public static final String URL_STRING_REQ = "http://api.androidhive.info/volley/string_response.html";
        public static final String URL_IMAGE = "http://api.androidhive.info/volley/volley-image.jpg";
    }
}
