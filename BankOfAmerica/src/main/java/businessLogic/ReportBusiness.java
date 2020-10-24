package businessLogic;

import dataAccess.ReportDataAccess;
import model.Report;

import java.util.List;

public class ReportBusiness {
    private ReportDataAccess reportDataAccess;
    public  ReportBusiness(){
        reportDataAccess = new ReportDataAccess();
    }
    public void add(Report report){
        reportDataAccess.addReport(report);
    }

    public List<Report> searchAfterId(int id){
        List<Report> list = reportDataAccess.searchAfterId(id);
        if(list == null) return null;
        return list;
    }

    public void update(Report report){
        reportDataAccess.updateReport(report);

    }
}
