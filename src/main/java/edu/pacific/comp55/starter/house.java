package edu.pacific.comp55.starter;

public class house {
	//sets the time of the house
		private int time;
		
		//checks when it's night or day 
		private Boolean isDark;
		
		//the number of dead people
		private int deadpeople;
		
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public Boolean getIsDark() {
			return isDark;
		}
		public void setIsDark(Boolean isDark) {
			this.isDark = isDark;
		}
		public int getDeadpeople() {
			return deadpeople;
		}
		public void setDeadpeople(int deadpeople) {
			this.deadpeople = deadpeople;
		}

}
