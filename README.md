# :rocket: HumanResourceManagementSystem

# :pushpin: Steps
1. İş Arayanlar sisteme kayıt olabilmelidir. ✔️
2. İş verenler sisteme kayıt olabilmelidir. ✔️  ️
3. Sisteme genel iş pozisyonu isimleri eklenebilmelidir. ✔️
4. İş verenler listelenebilmelidir. ✔️
5. İş arayanlar listelenebilmelidir. ✔️
6. İş pozisyonları listelenebilmelidir. ✔️
7. Fake Mernis oluşturuldu. ✔️
8. Sahte e-posta servisi eklendi. ✔️
9. Daha önce kayıtlı e-posta ve tcno alanlarının kontrolü için işlemler eklendi. ✔️
10. Ekleme işleminde girilen alanların boş olup olmadığını kontrol eden işlemler eklendi. ✔️
11. Result yapısı daha güzel çıktılar alınabilmesi için entegre edildi.  ✔️
12. Mesaj yapısı daha güzel hale getirildi. ✔️
13. İş Motoru ve Kural Motorları eklendi.  ✔️
14. İş verenler sisteme iş ilanı ekleyebilmelidir.  ✔️
15. Sistemdeki tüm aktif iş ilanları listelenebilmelidir. ✔️
16. Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir. ✔️
17. Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.  ✔️
18. İş verenler sistemdeki bir ilanı kapatabilmelidir. (Pasif ilan)  ✔️
19. Adaylar sisteme CV girişi yapabilmelidir.  ✔️
20. Bir adaya ait tüm CV bilgisi görüntülenebilmelidir. ✔️
21. Cloudinary Eklendi. ✔️



![databaseandtables](https://user-images.githubusercontent.com/16624085/117002547-58fa7380-acec-11eb-9d13-9b8ac5f4532b.png)
## :sparkles: PostgreSQL Database Tables
- [HRMS.sql](https://github.com/furkanpasaoglu/HumanResourceManagementSystem/blob/master/hrms.sql) *(Tablonuzu linkde gördüğünüz şekilde oluşturun)*
- [Cloudinary](https://github.com/furkanpasaoglu/HumanResourceManagementSystem/blob/master/src/main/java/kodlamaio/hrms/core/utilities/helpers/CloudinaryManager.java) *(Burayı Cloudinary hesabı oluşturarak doldurunuz)*
### :pushpin: Candidates
<table style="text-align:center">
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;"> 
            <th>user_id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>identity_number</th>
            <th>year_of_birth</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>Furkan</td>
            <td>Paşaoğlu</td>
            <td>12345678910</td>
            <td>06.08.1999</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

###  :pushpin: Employers

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>user_id</th>
            <th>company_name</th>
            <th>website</th>
            <th>phone</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>2</td>
            <td>Kodlama.io</td>
            <td>kodlama.io</td>
            <td>123456789</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

### :pushpin: Employers Verifications

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>employer_id</th>
            <th>confirm</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>2</td>
            <td>false</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

###  :pushpin: Job Positions

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>job_position_id</th>
            <th>name</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>Software Developer</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Full Stack Developer</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>3</td>
            <td>Front End Developer</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

###  :pushpin: System Employees

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>user_id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>Furkan</td>
            <td>Paşaoğlu</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

###  :pushpin: Users

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>id</th>
            <th>email</th>
            <th>password</th>
            <th>confirm_password</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>furkan.pasaoglu99@gmail.com</td>
            <td>12345678</td>
            <td>12345678</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>2</td>
            <td>kodlamaio@kodlamaio.com</td>
            <td>12345678</td>
            <td>12345678</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

###  :pushpin: Cities

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>city_id</th>
            <th>city_name</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>Adana</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Adıyaman</td>
        </tr>
    </tbody>
</table>

###  :pushpin: Job Advertisements

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>job_advertisement_id</th>
            <th>employer_id</th>
            <th>job_position_id</th>
            <th>city_id</th>
            <th>description</th>
            <th>salary_min</th>
            <th>salary_max</th>
            <th>number_of_open_job_position</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>1</th>
            <th>1</th>
            <th>1</th>
            <th>1</th>
            <th>Info: Test 1</th>
            <th>2500</th>
            <th>3500</th>
            <th>5</th>
            <th>28/05/2021</th>
            <th>true</th>
        </tr>
    </tbody>
</table>

###  :pushpin: Verifications

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>user_id</th>
            <th>confirm</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>1</td>
            <td>true</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
        <tr>
            <td>2</td>
            <td>false</td>
            <td>10.05.2021</td>
            <td>true</td>
        </tr>
    </tbody>
</table>

###  :pushpin: Resumes

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>resume_id</th>
            <th>education_id</th>
            <th>work_experience_id</th>
            <th>candidate_id</th>
            <th>foreign_language_id</th>
            <th>cover_letter</th>
            <th>github_link</th>
            <th>linkedin_link</th>
            <th>image_url</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>1</th>
            <th>1</th>
            <th>1</th>
            <th>1</th>
            <th>1</th>
            <th>Deneme Önyazı</th>
            <th>furkanpasaoglu</th>
            <th>furkanpasaoglu</th>
            <th>cloudinary.com</th>
            <th>02/06/2021</th>
            <th>true</th>
        </tr>
    </tbody>
</table>

###  :pushpin: Work Experiences

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>work_experience_id</th>
            <th>job_name</th>
            <th>job_position_name</th>
            <th>candidate_id</th>
            <th>start_date</th>
            <th>end_date</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>1</th>
            <th>Deneme</th>
            <th>Deneme deneme</th>
            <th>1</th>
            <th>06/08/2020</th>
            <th>05/06/2021</th>
            <th>02/06/2021</th>
            <th>true</th>
        </tr>
    </tbody>
</table>

###  :pushpin: Technologies

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>technology_id</th>
            <th>name</th>
            <th>candidate_id</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>1</th>
            <th>C#</th>
            <th>1</th>
            <th>02/06/2021</th>
            <th>true</th>
        </tr>
    </tbody>
</table>

###  :pushpin: Foreign Languages

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>foreign_language_id</th>
            <th>language_name</th>
            <th>language_level</th>
            <th>candidate_id</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>1</th>
            <th>İngilizce</th>
            <th>3</th>
            <th>1</th>
            <th>06/02/2021</th>
            <th>true</th>
        </tr>
    </tbody>
</table>

###  :pushpin: Educations

<table>
    <thead>
        <tr style="color:#ff9f43; background-color:#222f3e;">
            <th>education_id</th>
            <th>candidate_id</th>
            <th>school_name</th>
            <th>start_date</th>
            <th>graduation_date</th>
            <th>create_date</th>
            <th>active</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th>1</th>
            <th>1</th>
            <th>Kocaeli Üniversitesi</th>
            <th>02/06/2020</th>
            <th>02/07/2020</th>
            <th>02/06/2021</th>
            <th>true</th>
        </tr>
    </tbody>
</table>

## :pencil2:Authors
* **Furkan Paşaoğlu** - [furkanpasaoglu](https://github.com/furkanpasaoglu)
