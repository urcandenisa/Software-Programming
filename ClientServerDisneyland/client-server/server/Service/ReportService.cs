using System;
using server.Repository;
using core.Models;
using System.Collections.Generic;

namespace server.Service
{
    public class ReportService
    {
        private IReportRepository context;
        public ReportService()
        {
            context = new ReportRepository();
        }

        public void add(Report report)
        {
            context.add(report);
        }

        public List<Report> getAllReports()
        {
            List<Report> reports = context.getAllReports();
            if (reports == null) return null;
            return reports;
        }

        public List<Report> findByUserID(int id)
        {
            List<Report> reports = context.findByUserID(id);
            if (reports == null) return null;
            return reports;
        }

        public void delete(Report report)
        {
            context.delete(report);
        }
    }
}
