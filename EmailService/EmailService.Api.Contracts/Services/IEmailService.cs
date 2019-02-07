using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace EmailService.Api.Contracts.Services
{
    public interface IEmailService
    {
        /// <summary>
        /// Method to send email.
        /// </summary>
        /// <returns></returns>
        Task SendEmailAsync();
    }
}
