using System;
using System.Collections.Generic;
using System.Text;

namespace EmailService.Api.Models
{
    public class EmailConfiguration
    {
        public string MailServer { get; set; }
        public string MailServerUsername { get; set; }
        public string MailServerPassword { get; set; }
        public string SenderName { get; set; }
        public string SenderEmail { get; set; }
        public string AdminSenderEmail { get; set; }
        public int Port { get; set; }
    }
}
