using EmailService.Api.Models.Models;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace EmailService.Api.Contracts.Repositories
{
    public interface IEmailRepository : IDisposable
    {
        IEnumerable<Email> GetEmails();
        Task SaveAsync();
    }
}
