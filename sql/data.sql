USE [decision_tree_c45_db]
GO
/****** Object:  Table [dbo].[teacher_course_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[teacher_course_tb](
	[teacher_course_id] [int] IDENTITY(1,1) NOT NULL,
	[course_id] [int] NULL,
	[teacher_account_id] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[teacher_course_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[teacher_course_tb] ON
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (6, 1, 4, CAST(0x0000A8E60188B066 AS DateTime))
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (7, 2, 4, CAST(0x0000A8E601890BB9 AS DateTime))
INSERT [dbo].[teacher_course_tb] ([teacher_course_id], [course_id], [teacher_account_id], [update_date]) VALUES (9, 3, 4, CAST(0x0000A8E601891122 AS DateTime))
SET IDENTITY_INSERT [dbo].[teacher_course_tb] OFF
/****** Object:  Table [dbo].[survey_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[survey_tb](
	[survey_id] [int] IDENTITY(1,1) NOT NULL,
	[before_class_understand] [int] NULL,
	[classroom_leaning] [int] NULL,
	[operate_computer_leaning_time] [int] NULL,
	[peacetime_score] [int] NULL,
	[student_account_id] [int] NULL,
	[teacher_course_id] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[survey_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[student_class_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[student_class_tb](
	[student_class_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[student_class_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[student_class_tb] ON
INSERT [dbo].[student_class_tb] ([student_class_id], [duty], [name], [update_date]) VALUES (1, N'二年级A班', N'二年A班', CAST(0x0000A8E6017CE643 AS DateTime))
INSERT [dbo].[student_class_tb] ([student_class_id], [duty], [name], [update_date]) VALUES (2, N'三年级B班', N'三年B班', CAST(0x0000A8E6017CEEAD AS DateTime))
SET IDENTITY_INSERT [dbo].[student_class_tb] OFF
/****** Object:  Table [dbo].[score_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[score_tb](
	[score_id] [int] IDENTITY(1,1) NOT NULL,
	[score] [float] NULL,
	[student_account_id] [int] NULL,
	[teacher_course_id] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[score_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role_tb](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[role_tb] ON
INSERT [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (1, N'超级管理员', N'超级管理员', CAST(0x0000A8E60156A386 AS DateTime))
INSERT [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (2, N'教师', N'教师', CAST(0x0000A8E60156A394 AS DateTime))
INSERT [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (3, N'学生', N'学生', CAST(0x0000A8E60156A394 AS DateTime))
SET IDENTITY_INSERT [dbo].[role_tb] OFF
/****** Object:  Table [dbo].[positional_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[positional_tb](
	[positional_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[positional_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[positional_tb] ON
INSERT [dbo].[positional_tb] ([positional_id], [duty], [name], [update_date]) VALUES (1, N'普通教师', N'讲师', CAST(0x0000A8E60165FFF9 AS DateTime))
INSERT [dbo].[positional_tb] ([positional_id], [duty], [name], [update_date]) VALUES (2, N'比讲师高一级', N'副教授', CAST(0x0000A8E601661A15 AS DateTime))
INSERT [dbo].[positional_tb] ([positional_id], [duty], [name], [update_date]) VALUES (3, N'比副教授高一级别', N'教授', CAST(0x0000A8E601662A8F AS DateTime))
SET IDENTITY_INSERT [dbo].[positional_tb] OFF
/****** Object:  Table [dbo].[major_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[major_tb](
	[major_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[major_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[major_tb] ON
INSERT [dbo].[major_tb] ([major_id], [duty], [name], [update_date]) VALUES (1, N'通信电子技术', N'通信工程', CAST(0x0000A8E60161F9B4 AS DateTime))
INSERT [dbo].[major_tb] ([major_id], [duty], [name], [update_date]) VALUES (2, N'电脑', N'计算机与科学技术', CAST(0x0000A8E6016209BB AS DateTime))
SET IDENTITY_INSERT [dbo].[major_tb] OFF
/****** Object:  Table [dbo].[course_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[course_tb](
	[course_id] [int] IDENTITY(1,1) NOT NULL,
	[duty] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[type] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[course_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[course_tb] ON
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (1, N'中华中文，博大进深！', N'语文', NULL, CAST(0x0000A8E6015F114E AS DateTime))
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (2, N'逻辑', N'数学', NULL, CAST(0x0000A8E6015F217B AS DateTime))
INSERT [dbo].[course_tb] ([course_id], [duty], [name], [type], [update_date]) VALUES (3, N'英文的国际化', N'英语', NULL, CAST(0x0000A8E6015F3D99 AS DateTime))
SET IDENTITY_INSERT [dbo].[course_tb] OFF
/****** Object:  Table [dbo].[analyse_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[analyse_tb](
	[analyse_id] [int] IDENTITY(1,1) NOT NULL,
	[business_id] [int] NULL,
	[conclusion] [varchar](255) NULL,
	[score] [float] NULL,
	[sub_type] [int] NULL,
	[type] [int] NULL,
	[update_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[analyse_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[account_tb]    Script Date: 05/21/2018 00:16:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[account_tb](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[age] [int] NULL,
	[create_date] [datetime] NULL,
	[identifier] [varchar](255) NULL,
	[login_date] [datetime] NULL,
	[major_id] [int] NULL,
	[password] [varchar](255) NULL,
	[positional_id] [int] NULL,
	[realname] [varchar](255) NULL,
	[role_id] [int] NULL,
	[sex] [int] NULL,
	[student_class_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[account_tb] ON
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (1, NULL, CAST(0x0000A8E6015719C1 AS DateTime), N'1000', CAST(0x0000A8E6015719C1 AS DateTime), NULL, N'11874bb6149dd45428da628c9766b252', NULL, N'聂跃', 1, NULL, NULL)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (2, 33, CAST(0x0000A8E60175D8B0 AS DateTime), N'201805202', CAST(0x0000A8E60175D8B0 AS DateTime), 0, N'11874bb6149dd45428da628c9766b252', 3, N'张一发', 2, 2, 0)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (3, 25, CAST(0x0000A8E6017735E8 AS DateTime), N'201805203', CAST(0x0000A8E6017735E8 AS DateTime), 0, N'11874bb6149dd45428da628c9766b252', 2, N'孙明', 2, 2, 0)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (4, 22, CAST(0x0000A8E6017756B8 AS DateTime), N'201805204', CAST(0x0000A8E6017756B8 AS DateTime), 0, N'11874bb6149dd45428da628c9766b252', 1, N'刘三三', 2, 2, 0)
INSERT [dbo].[account_tb] ([account_id], [age], [create_date], [identifier], [login_date], [major_id], [password], [positional_id], [realname], [role_id], [sex], [student_class_id]) VALUES (6, 22, CAST(0x0000A8E6017DD59C AS DateTime), N'201805205', CAST(0x0000A8E6017DD59C AS DateTime), 1, N'11874bb6149dd45428da628c9766b252', 0, N'张萌萌', 3, 2, 1)
SET IDENTITY_INSERT [dbo].[account_tb] OFF
