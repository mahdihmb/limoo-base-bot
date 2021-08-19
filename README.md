<div dir="rtl">

## بات بیس لیمو
از این کد می‌توانید برای نوشتن یک بات [لیمو](https://web.limoo.im/) که نیازمند دیتابیس است، استفاده کنید.  
در ضمن اگر علاقه‌مند به استفاده از این کد هستید ولی بات شما به دیتابیس نیاز ندارد، می‌توانید قسمت های مرتبط با دیتابیس را حذف کرده و بات خود را بنویسید.  
اکثر کارهای زیرساختی انجام شده است و فقط کافی است منطق بات را پیاده‌سازی کنید.
زیرساخت های موارد زیر فراهم شده است و می‌توانید از آن‌ها استفاده کنید:
- config.properties (با امکان قرار دادن کانفیگ لوکال برای جایگزین شدن)
- messageService (فایل messages_fa.properties در مسیر resources/i18n قرار دارد)
- hibernate (فایل های مپینگ در مسیر resources/hbm قرار می‌گیرند)
- flyway (مایگریشن‌ها در مسیر resources/migrations قرار می‌گیرند)

برای شروع، این repo را clone/fork کرده و سپس عبارت `limoo-base-bot` و `LIMOO_BASE_BOT` را در کل کد، به عبارت مورد نظرتان تغییر دهید.
حال به نوشتن منطق بات بپردازید.

کلاس های `Test` و `TestDAO` به همراه مپینگ `Test.hbm.xml` و مایگریشن `V1__Initial_version.sql` نیز برای نمونه در کد گذاشته شده اند.  
همچنین یک تکه کد نمونه در کلاس `LimooBot` برای شروع کار گذاشته شده است (صرفا برای آشنایی کار با کلاس `DAO` و هندل کردن ایونت پیام).
***
### تکنولوژي‌های مورد نیاز:
- java
- postgresql
***
### راه‌اندازی بات:
1. یک دیتابیس جدید ایجاد کنید (مثلا با نام `database_name`)
2. یک فایل `config.properties` در یک جایی از سیستم ایجاد کرده و آدرس آن را در متغیر محیطی `LIMOO_BASE_BOT_CONFIG` قرار دهید. یا به سادگی فقط فایل config.properties موجود در کد را تغییر دهید (به جای ایجاد کانفیگ لوکال)
3. در فایل `config.properties` که ایجاد کرده‌اید (یا فایل کانفیگ موجود در کد)، موارد زیر را تنظیم کنید:
</div>

```properties
# Bot
bot.limooUrl=https://web.limoo.im/Limonad
bot.username=bot_username
bot.password=bot_password

# DB
db.host=localhost
db.port=5432
db.name=database_name
db.username=db_username
db.password=db_password
```

<div dir="rtl">

4. دستور زیر را برای پیکربندی دیتابیس اجرا کنید (این دستور فقط یکبار باید اجرا شود):
</div>

```bash
./gradlew resetAndInitDB
```

<div dir="rtl">

5. دستور زیر را برای شروع به کار بات اجرا کنید:
</div>

```bash
./gradlew runBot
```

<div dir="rtl">

همچنین می‌توانید به جای استفاده از تسک gradle بالا برای اجرای بات، با دستور
</div>

```bash
./gradlew jar
```

<div dir="rtl">

یک جر از بات خود بسازید (که در مسیر build/libs ایجاد می‌شود) و سپس با دستور زیر آن را اجرا کنید:
</div>

```bash
java -jar limoo-base-bot.jar
```
