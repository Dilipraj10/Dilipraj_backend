//package com.excel.hibernet_demo.onetomany;
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//	@Getter
//	@Setter
//	@AllArgsConstructor
//	@NoArgsConstructor
//	@Entity
//	@Table(name = "student")
//	public class Student {
//		
//		
//		public int getId() {
//			return id;
//		}
//
//		public void setId(int id) {
//			this.id = id;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public int getAge() {
//			return age;
//		}
//
//		public void setAge(int age) {
//			this.age = age;
//		}
//
//		public List<Laptop> getLaptops() {
//			return laptops;
//		}
//
//		public void setLaptops(List<Laptop> laptops) {
//			this.laptops = laptops;
//		}
//
//		@Id
//		@GeneratedValue(strategy = GenerationType.AUTO)
//		@Column(name = "student_id")
//		private int id;
//		
//		@Column(name = "student_name")
//		private String name;
//		
//		@Column(name = "student_age")
//		private int age;
//		
//		@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
//		private List <Laptop> laptops;
//
//}
