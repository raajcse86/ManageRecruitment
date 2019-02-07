using System;
using System.Collections.Generic;
using System.Text;

namespace EmailService.Api.Models.Models
{
    public class Email
    {
        public int Id { get; set; }
        public string Subject { get; set; }
        public string Body { get; set; }
        public string Address { get; set; }
    }
}
