using System;
using core.Models;
using server.DataAccess;
using System.Collections.Generic;

namespace server.Repository
{
    public class ReportRepository : IReportRepository
    {
        private readonly DBContext _context;
        public ReportRepository()
        {
            _context = new DBContext();
        }

        public void add(Report report)
        {
            _context.dataAccess.Insert(report);
        }

        public List<Report> getAllReports()
        {
            var list = _context.dataAccess.Table<Report>();
            List<Report> reports = new List<Report>();
            foreach(Report report in list)
            {
                reports.Add(report);
            }
            return reports;
        }

        public void delete(Report report)
        {
            _context.dataAccess.Delete(report);
        }

        public List<Report> findByUserID(int id)
        {
            var list = _context.dataAccess.Table<Report>();
            List<Report> reports = new List<Report>();
            foreach (Report report in list)
            {
                if(report.ID == id)
                {
                    reports.Add(report);
                }
            }
            return reports;
        }
    }
}
