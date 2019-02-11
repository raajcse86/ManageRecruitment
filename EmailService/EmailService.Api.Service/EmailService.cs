using EmailService.Api.Contracts.Repositories;
using EmailService.Api.Contracts.Services;
using EmailService.Api.Models;
using EmailService.Api.Models.Models;
using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Mail;
using System.Text;
using System.Threading.Tasks;

namespace EmailService.Api.Services.Email
{
    public class EmailService : IEmailService
    {
        private readonly IEmailRepository _emailRepository;
        private readonly EmailConfiguration _emailConfiguration;
        public EmailService(IEmailRepository emailRepository, EmailConfiguration emailConfiguration)
        {
            _emailRepository = emailRepository;
            _emailConfiguration = emailConfiguration;
        }

        async public Task<int> SendEmailAsync(Models.Models.Email email)
        {
            using (var client = new SmtpClient(_emailConfiguration.MailServer, _emailConfiguration.Port))
            {
                var mailMessage = new MailMessage(_emailConfiguration.SenderEmail, email.ToAddress, email.Subject, email.Body);

                var sendMail = client.SendMailAsync(mailMessage);

                sendMail.Wait();

                var addEmailToDB = _emailRepository.AddEmailAsync(email);

                addEmailToDB.Wait();

                return await _emailRepository.SaveAsync();
            }
        }
    }
}
