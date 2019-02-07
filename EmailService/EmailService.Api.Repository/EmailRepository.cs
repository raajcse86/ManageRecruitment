using EmailService.Api.Contracts.Repositories;
using EmailService.Api.Models.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmailService.Api.Repositories
{
    public class EmailRepository : IEmailRepository, IDisposable
    {
        private DataContext _context;
        private bool disposed = false;

        public EmailRepository(DataContext dataContext)
        {
            this._context = dataContext;
        }

        public IEnumerable<Email> GetEmails()
        {
            return _context.Emails.ToList();
        }

        async public Task SaveAsync()
        {
            await _context.SaveChangesAsync();
        }

        protected virtual void Dispose(bool disposing)
        {
            if (!this.disposed)
            {
                if (disposing)
                {
                    _context.Dispose();
                }
            }
            this.disposed = true;
        }
        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }
    }
}
