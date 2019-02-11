using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace EmailService.Api.Models.Models
{
    public class Email
    {
        [Key]
        public int Id { get; set; }
        [StringLength(150)]
        public string Subject { get; set; }
        public string Body { get; set; }
        public string ToAddress { get; set; }
        public string CC { get; set; }
        public string BCC { get; set; }
    }
}
