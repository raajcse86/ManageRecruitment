using EmailService.Api.Contracts.Repositories;
using EmailService.Api.Contracts.Services;
using EmailService.Api.Models;
using System;
using System.Collections.Generic;
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
        async public Task SendEmailAsync()
        {
            var config = _emailConfiguration.MailServer;
            await _emailRepository.SaveAsync();
        }
    }
}
