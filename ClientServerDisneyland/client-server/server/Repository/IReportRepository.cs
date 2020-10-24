using System;
using System.Collections.Generic;
using core.Models;
namespace server.Repository
{
    public interface IReportRepository
    {
        void add(Report report);
        List<Report> getAllReports();
        List<Report> findByUserID(int id);
        void delete(Report report);
    }
}
