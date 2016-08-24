/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocr;

import hodclient.HODApps;
import hodclient.HODClient;
import hodclient.IHODClientCallback;
import hodresponseparser.HODErrorCode;
import hodresponseparser.HODErrorObject;
import hodresponseparser.HODResponseParser;
import hodresponseparser.OCRDocumentResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aless
 */
public class HPEImplementor implements MotoreOCR, IHODClientCallback{

    private HODClient client = new HODClient("556fdd83-62ed-4851-95ef-f77d14f59775", this);
    private HODResponseParser parser = new HODResponseParser();
    private String hodApp = "";
    private String filePath;
    private String finalResult = "";
    private Map<String, Object> params;
    private String language = "en-US";
    
    @Override
    public void setLanguage(String language) {
        
        if(language.equals("Italiano")){
            language = "it-IT";
        }else language = "en-US";
        
        this.language = language;
    }

    @Override
    public String doOCR(File imageFile) {
        
        this.filePath = imageFile.getAbsolutePath();
        hodApp = HODApps.OCR_DOCUMENT;
        params = new HashMap<>();
        
        // pass a single file as File object
        File mediaFile = new File(filePath);
        
        // pass a single file as filename
        // String mediaFile = fileName;
        
        params.put("file", mediaFile);
        params.put("language", language);
        
        client.PostRequest(params, hodApp, HODClient.REQ_MODE.ASYNC);
        return resultOCR("");
    
    }
    
    private String resultOCR(String response){
        requestCompletedWithContent(response);
        return finalResult;
    }
    
    @Override
    public void requestCompletedWithContent(String response) {
        
        OCRDocumentResponse resp = parser.ParseOCRDocumentResponse(response);
        if (resp != null) {
            for (OCRDocumentResponse.TextBlock doc : resp.text_block)
            {
                finalResult += doc.text;
            }
            //System.out.println(result);
        } else {
            List<HODErrorObject> errors = parser.GetLastError();
            for (HODErrorObject err : errors) {
                if (err.error == HODErrorCode.QUEUED) {
                    try {
                        Thread.sleep(3000);
                        client.GetJobStatus(err.jobID);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                } else if (err.error == HODErrorCode.IN_PROGRESS) {
                    try {
                        Thread.sleep(10000);
                        client.GetJobStatus(err.jobID);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    String result = "\n\nError:\r\n";
                    result += "Code: " + String.format("%d\r\n", err.error);
                    result += "Reason: " + err.reason + "\r\n";
                    result += "Detail: " + err.detail + "\r\n";
                    //System.out.println(result);
                }
            }
        }
    }
    
    @Override
    public void requestCompletedWithJobID(String response) {
        // TODO Auto-generated method stub
        String jobID = parser.ParseJobID(response);
        if (jobID.length() > 0)
            client.GetJobStatus(jobID);
    }
    
    @Override
    public void onErrorOccurred(String errorMessage) {
        // TODO Auto-generated method stub
        System.out.println("Error: " + errorMessage);
    }
}
