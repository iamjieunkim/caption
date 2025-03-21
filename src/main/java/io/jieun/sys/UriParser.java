package io.jieun.sys;

import java.util.HashMap;
import java.util.Map;

public class UriParser {


    /*
    구분/기능
    controller/target-> none
    controller/target/param1=value1 -> 단일 파라미터
    controller/target/param1=value1&param2=value2 -> 복합 파라미터


     */
    private String URI;
    private String controllerCode;
    private String target;


    private boolean isValidUri = true;
    private Map<String, Object> parameters = new HashMap<>();

    public UriParser(String url) {
        this.URI = parse(url);
    }

    protected String parse(String uri) {


        if( !uri.startsWith("/") ) {
            isValidUri = false;
            return uri;
        }

        //["/controller/target", "param1 = value1"]
        String[] uriSplit = uri.split("\\?", 2);


        // /controller/target
        if(uriSplit.length == 2) {
            //파라미터 있을 때
            setParameters(uriSplit[1]);

        }

        String[] uriFront = uriSplit[0].split("/");
        if(uriFront.length != 3) {
            isValidUri = false;
            return uri;
        }

        //[ '', 'controller', 'target']
        controllerCode = uriFront[1];
        target = uriFront[2];

        return uri;

    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }

    protected void setParameters(String uriPart){
        try{
            //복합이 들어올수도 있고 단일 파라미터가 들어올 수 도 있기 때문에 구분해줘야함
            if( uriPart.contains("&") ) {
                //param1=value1&param2=value2
                //param1=value1&param2=value2&param3=value3

                String[] split = uriPart.split("&");

                for (String s : split) {

                    String[] parameterData = s.split("=", 2);

                    //if(parameterData[1].equals("")){
                    if(parameterData[1].isEmpty()) {
                        throw new IllegalArgumentException("잘못된 파라미터 값이 입력되었습니다. URL을 확인해주세요.");
                    }

                    parameters.put(parameterData[0], parameterData[1]);


                }


            }else{
                //param1=value1
                //value안에 =이 들어가 있는 경우를 생각을 해야한다.
                //param1=valu=====e1
                String[] split = uriPart.split("=", 2);

                if( split[1].isEmpty() ) {
                    throw new IllegalArgumentException("잘못된 파라미터 값이 입력되었습니다. URL을 확인해주세요.");
                }

                parameters.put(split[0], split[1]);
            }
        } catch(ArrayIndexOutOfBoundsException | IllegalArgumentException e ) {
            this.isValidUri = false;
        }



    }


    protected String getURI() {
        return URI;
    }

    protected void setURI(String URI) {
        this.URI = URI;
    }

    protected String getControllerCode() {
        return controllerCode;
    }

    protected void setControllerCode(String controllerCode) {
        this.controllerCode = controllerCode;
    }

    protected String getTarget() {
        return target;
    }

    protected void setTarget(String target) {
        this.target = target;
    }

    protected boolean isValidUri() {
        return isValidUri;
    }

    protected void setValidUri(boolean validUri) {
        isValidUri = validUri;
    }

    protected void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
