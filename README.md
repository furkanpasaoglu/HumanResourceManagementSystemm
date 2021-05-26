# :rocket: HumanResourceManagementSystem

# :pushpin: Steps
1. İş Arayanlar sisteme kayıt olabilmelidir. ✔️
2. İş verenler sisteme kayıt olabilmelidir. ✔️  ️
3. Sisteme genel iş pozisyonu isimleri eklenebilmelidir. ✔️
4. İş verenler listelenebilmelidir. ✔️
5. İş arayanlar listelenebilmelidir. ✔️
6. İş pozisyonları listelenebilmelidir. ✔️
7. Fake Mernis oluşturuldu. ✔️
8. Gerçek Mernis oluşturuldu. ✔️
9. Sahte e-posta servisi eklendi. ✔️
10. Daha önce kayıtlı e-posta ve tcno alanlarının kontrolü için işlemler eklendi. ✔️
11. Ekleme işleminde girilen alanların boş olup olmadığını kontrol eden işlemler eklendi. ✔️
12. Result yapısı daha güzel çıktılar alınabilmesi için entegre edildi.  ✔️
13. Mesaj yapısı daha güzel hale getirildi. ✔️
14. İş Motoru ve Kural Motorları eklendi.  ✔️



![databaseandtables](https://user-images.githubusercontent.com/16624085/117002547-58fa7380-acec-11eb-9d13-9b8ac5f4532b.png)
## :sparkles: PostgreSQL Database Tables
- [HRMS.sql](https://github.com/furkanpasaoglu/HumanResourceManagementSystem/blob/master/hrms.sql) *(Tablonuzu linkde gördüğünüz şekilde oluşturun)*
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

## :pencil2:Authors
* **Furkan Paşaoğlu** - [furkanpasaoglu](https://github.com/furkanpasaoglu)
