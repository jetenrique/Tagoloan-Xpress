const assetPathPrefix = "https://www.figma.com/api/mcp/asset/de44737e-5a20-4626-ae94-ec2459d6eb9f";
const imgContainer = `${assetPathPrefix}/5f578.svg`;
const imgContainer1 = `${assetPathPrefix}/9812a.svg`;
const imgContainer2 = `${assetPathPrefix}/f1263.svg`;
const imgIconBack = `${assetPathPrefix}/82c1c.svg`;
const imgIconClock = `${assetPathPrefix}/38ef6.svg`;
const imgIconCheck = `${assetPathPrefix}/a83fa.svg`;

export default function VerificationProgressStatus() {
  return (
    <div className="bg-[#fbf9f1] relative size-full" data-node-id="3:1701" data-name="Verification Progress Status">
      <div className="absolute bg-[#fbf9f1] content-stretch flex flex-col h-[844px] items-start left-0 overflow-clip top-0 w-[390px]" data-node-id="130:3" data-name="Screen">
        <div className="content-stretch flex h-[24px] items-center justify-between px-[16px] relative shrink-0 w-full" data-node-id="130:4" data-name="Container">
          <div className="content-stretch flex flex-col items-start relative shrink-0" data-node-id="130:5" data-name="Container">
            <div className="[word-break:break-word] flex flex-col font-['Plus_Jakarta_Sans:SemiBold'] font-semibold justify-center leading-[0] relative shrink-0 text-[#18181f] text-[11px] tracking-[0.5px] whitespace-nowrap" data-node-id="130:6">
              <p className="leading-[16px]">9:41</p>
            </div>
          </div>
          <div className="content-stretch flex gap-[4px] items-center relative shrink-0" data-node-id="130:7" data-name="Container">
            <div className="relative shrink-0 size-[11.667px]" data-node-id="130:8" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer} />
            </div>
            <div className="h-[9.917px] relative shrink-0 w-[14px]" data-node-id="130:10" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer1} />
            </div>
            <div className="h-[11.667px] relative shrink-0 w-[5.833px]" data-node-id="130:12" data-name="Container">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgContainer2} />
            </div>
          </div>
        </div>
        <div className="content-stretch flex gap-[12px] items-center overflow-clip px-[16px] py-[8px] relative shrink-0 w-full" data-node-id="130:14" data-name="App bar">
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip relative rounded-[20px] shrink-0 size-[40px]" data-node-id="130:15" data-name="Back button">
            <div className="relative shrink-0 size-[18px]" data-node-id="130:16" data-name="icon/back">
              <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconBack} />
            </div>
          </a>
          <div className="content-stretch flex flex-[1_0_0] flex-col items-start min-w-px overflow-clip relative" data-node-id="130:18" data-name="Container">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] relative shrink-0 text-[#18181f] text-[18px] w-full" data-node-id="130:19">
              Application status
            </p>
          </div>
        </div>
        <div className="content-stretch flex flex-[1_0_0] flex-col gap-[16px] items-start min-h-px overflow-clip px-[16px] py-[8px] relative w-full" data-node-id="130:21" data-name="Body">
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[6px] items-center overflow-clip px-[16px] py-[24px] relative rounded-[16px] shrink-0 w-full" data-node-id="130:22" data-name="Status">
            <div className="bg-[#fff7e0] content-stretch flex items-center justify-center overflow-clip relative rounded-[28px] shrink-0 size-[56px]" data-node-id="130:23" data-name="Container">
              <div className="relative shrink-0 size-[26px]" data-node-id="130:24" data-name="icon/clock">
                <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconClock} />
              </div>
            </div>
            <div className="h-[6px] relative shrink-0 w-px" data-node-id="130:27" data-name="Spacer" />
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] min-w-full relative shrink-0 text-[#18181f] text-[20px] text-center w-[min-content]" data-node-id="130:28">
              Under review
            </p>
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[13px] text-center w-[min-content]" data-node-id="130:29">{`Usually 24–48 hours. You can accept requests once you're approved.`}</p>
          </div>
          <div className="bg-white border border-[#ece8df] border-solid content-stretch flex flex-col items-start overflow-clip p-[16px] relative rounded-[16px] shrink-0 w-full" data-node-id="130:30" data-name="Progress">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-full relative shrink-0 text-[#6b6b73] text-[13px] w-[min-content]" data-node-id="130:31">
              Progress
            </p>
            <div className="h-[10px] relative shrink-0 w-px" data-node-id="130:32" data-name="Spacer" />
            <div className="content-stretch flex gap-[12px] items-center overflow-clip py-[8px] relative shrink-0 w-full" data-node-id="130:33" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[24px]" data-node-id="130:34" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:35" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:37">
                Account created
              </p>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] relative shrink-0 text-[#1e9e5a] text-[12px] whitespace-nowrap" data-node-id="130:38">
                Done
              </p>
            </div>
            <div className="content-stretch flex gap-[12px] items-center overflow-clip py-[8px] relative shrink-0 w-full" data-node-id="130:39" data-name="Container">
              <div className="bg-[#e6f5ec] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[24px]" data-node-id="130:40" data-name="Container">
                <div className="relative shrink-0 size-[13px]" data-node-id="130:41" data-name="icon/check">
                  <img alt="" className="absolute block inset-0 max-w-none size-full" src={imgIconCheck} />
                </div>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:43">
                Documents submitted
              </p>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] relative shrink-0 text-[#1e9e5a] text-[12px] whitespace-nowrap" data-node-id="130:44">
                Done
              </p>
            </div>
            <div className="content-stretch flex gap-[12px] items-center overflow-clip py-[8px] relative shrink-0 w-full" data-node-id="130:45" data-name="Container">
              <div className="bg-[#febc20] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[24px]" data-node-id="130:46" data-name="Container">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] relative shrink-0 text-[#18181f] text-[11px] whitespace-nowrap" data-node-id="130:47">
                  3
                </p>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] min-w-px relative text-[#18181f] text-[14px]" data-node-id="130:48">
                Admin verification
              </p>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] relative shrink-0 text-[#6b4e00] text-[12px] whitespace-nowrap" data-node-id="130:49">
                In progress
              </p>
            </div>
            <div className="content-stretch flex gap-[12px] items-center overflow-clip py-[8px] relative shrink-0 w-full" data-node-id="130:50" data-name="Container">
              <div className="bg-[#f3f1ea] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[24px]" data-node-id="130:51" data-name="Container">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[11px] whitespace-nowrap" data-node-id="130:52">
                  4
                </p>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#6b6b73] text-[14px]" data-node-id="130:53">
                Orientation
              </p>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] relative shrink-0 text-[#a3a3ab] text-[12px] whitespace-nowrap" data-node-id="130:54">
                Next
              </p>
            </div>
            <div className="content-stretch flex gap-[12px] items-center overflow-clip py-[8px] relative shrink-0 w-full" data-node-id="130:55" data-name="Container">
              <div className="bg-[#f3f1ea] content-stretch flex items-center justify-center overflow-clip relative rounded-[12px] shrink-0 size-[24px]" data-node-id="130:56" data-name="Container">
                <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Bold'] font-bold leading-[1.35] relative shrink-0 text-[#6b6b73] text-[11px] whitespace-nowrap" data-node-id="130:57">
                  5
                </p>
              </div>
              <p className="[word-break:break-word] flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal leading-[1.35] min-w-px relative text-[#6b6b73] text-[14px]" data-node-id="130:58">
                Final approval
              </p>
              <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:Medium'] font-medium leading-[1.35] relative shrink-0 text-[#a3a3ab] text-[12px] whitespace-nowrap" data-node-id="130:59">
                Next
              </p>
            </div>
          </div>
          <div className="[word-break:break-word] bg-white border border-[#ece8df] border-solid content-stretch flex flex-col gap-[10px] items-start leading-[1.35] overflow-clip p-[16px] relative rounded-[16px] shrink-0 text-[14px] w-full" data-node-id="130:60" data-name="Applicant">
            <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:61" data-name="Row – Applicant">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="130:62">
                Applicant
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="130:63">
                Juan Dela Cruz
              </p>
            </div>
            <div className="content-stretch flex gap-[12px] items-center overflow-clip relative shrink-0 w-full" data-node-id="130:64" data-name="Row – Rider ID">
              <p className="flex-[1_0_0] font-['Plus_Jakarta_Sans:Regular'] font-normal min-w-px relative text-[#6b6b73]" data-node-id="130:65">
                Rider ID
              </p>
              <p className="font-['Plus_Jakarta_Sans:SemiBold'] font-semibold relative shrink-0 text-[#18181f] whitespace-nowrap" data-node-id="130:66">
                TX-RDR-8924
              </p>
            </div>
          </div>
          <div className="flex-[1_0_0] min-h-px relative w-full" data-node-id="130:67" data-name="Flexible space" />
          <a className="bg-[#febc20] content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[15px] relative rounded-[14px] shrink-0 w-full" data-node-id="130:68" data-name="Button – Check status">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="130:69">
              Check status
            </p>
          </a>
          <a className="bg-white border border-[#ece8df] border-solid content-stretch cursor-pointer flex items-center justify-center overflow-clip py-[13px] relative rounded-[14px] shrink-0 w-full" data-node-id="130:71" data-name="Button – Log out">
            <p className="[word-break:break-word] font-['Plus_Jakarta_Sans:SemiBold'] font-semibold leading-[1.35] relative shrink-0 text-[#18181f] text-[15px] text-left whitespace-nowrap" data-node-id="130:72">
              Log out
            </p>
          </a>
        </div>
      </div>
    </div>
  );
}
