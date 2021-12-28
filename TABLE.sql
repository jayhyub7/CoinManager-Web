USE [coin]
GO
/****** Object:  Table [dbo].[external_content]    Script Date: 2021-12-29 오전 7:20:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[external_content](
	[external_site_code] [nvarchar](20) NOT NULL,
	[content_id] [nvarchar](20) NOT NULL,
	[nick_name] [nvarchar](50) NOT NULL,
	[title] [nvarchar](50) NULL,
	[content] [text] NULL,
	[comments] [text] NULL,
	[ins_date] [datetime] NULL,
	[upd_date] [datetime] NULL,
 CONSTRAINT [PK_external_content] PRIMARY KEY CLUSTERED
(
	[external_site_code] ASC,
	[content_id] ASC,
	[nick_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[external_writer]    Script Date: 2021-12-29 오전 7:20:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[external_writer](
	[member_email] [nvarchar](50) NOT NULL,
	[external_site_code] [nvarchar](20) NOT NULL,
	[nick_name] [nvarchar](50) NOT NULL,
	[ins_date] [datetime] NULL,
	[upd_date] [datetime] NULL,
 CONSTRAINT [PK_external_writer] PRIMARY KEY CLUSTERED
(
	[member_email] ASC,
	[external_site_code] ASC,
	[nick_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member]    Script Date: 2021-12-29 오전 7:20:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member](
	[email] [varchar](50) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[ins_date] [datetime] NULL,
	[upd_date] [datetime] NULL,
 CONSTRAINT [PK_member] PRIMARY KEY CLUSTERED
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
